/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatrmi.impl;
import chatrmi.remote.InterfaceChat;
import chatrmi.remote.Message;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author lheredia
 */
public class RemoteImpl extends UnicastRemoteObject implements InterfaceChat {
    private String username;
    //List <User> listUser = new ArrayList<User>();
    List <String> listUser = new ArrayList<>();
    List <Message> listMessages = new ArrayList<>();
    public RemoteImpl() throws RemoteException{
        super();
    }
    @Override
    public String isLoginValid(String username) throws RemoteException{
        username =  username.toLowerCase();
        if(!listUser.contains(username)){
            listUser.add(username);
            Path file=Paths.get(username+".inbox");
            try {
                Files.createFile(file);
            } catch (IOException ex) {
                Logger.getLogger(RemoteImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "OK";
        }
        else
            return "Usuario ya registrado";
    }

    @Override
    public String getUsername() throws Exception {
        return this.username;
    }

    public void setUsername() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void send(Message  msg) throws RemoteException {
        listUser.forEach(
                user->{
                    Path file=Paths.get(msg.getUser()+".inbox");
                    try(
                        ObjectOutputStream output=new ObjectOutputStream(Files.newOutputStream(file,StandardOpenOption.APPEND));
                    ){
                        output.writeObject(msg);
                    } catch (IOException ex) {
                        Logger.getLogger(RemoteImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        );
        System.out.println(msg.getUser() + ": " + msg.getMessage());
        
        
        listMessages.add(msg);
        //sendAll(message);
        //return msg;
    }

    @Override
    public String receive() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendAll(Message msg) throws RemoteException {
        
    }

    @Override
    public List<Message> getMessage(String user) throws RemoteException {
        
        return listMessages;
    }

    @Override
    public void setUsername(String oldName, String newName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getStatus(String msg) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getUsers() throws RemoteException {
        return this.listUser;
    }

    @Override
    public void logOut(String username) throws Exception {
        listUser.remove(username);
    }
    
}

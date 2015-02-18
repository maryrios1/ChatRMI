/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatrmi.impl;
import chatrmi.remote.InterfaceChat;
import chatrmi.remote.Message;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
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
                    Path file=Paths.get(user+".inbox");
                    writeMessage(msg,file);
                }
        );
        System.out.println(msg.getUser() + ": " + msg.getMessage());
        listMessages.add(msg);
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
        Path file=Paths.get(user+".inbox");
        return readAllMessages(file);
    }

    private static void writeMessage(Message msg,Path file){
                    try(
                        ObjectOutputStream  output=getObjectOutputStream(file);
                    ){
                        System.out.println("Writting on file: "+file.getFileName()+" msg: "+msg);
                        output.writeObject(msg);
                    } catch (IOException ex) {
                        Logger.getLogger(RemoteImpl.class.getName()).log(Level.SEVERE, "failed writing", ex);
                    }
    }
    /***
     *  this factory validates the existence of the file and depending on that it returns a
     *  write stream or a correct appendable stream
     * 
     * @param file to write
     * @return proper ObjectoustputStream
     * @throws IOException if any problem happened during the process
     */
    private static ObjectOutputStream getObjectOutputStream(Path file)throws IOException{
        if(Files.exists(file)){
        return new ObjectOutputStream(Files.newOutputStream(file,StandardOpenOption.APPEND,
                                    StandardOpenOption.WRITE
                            )){
                                @Override
                                protected void writeStreamHeader() throws IOException {
                                    // don't write header of appended Objects
                                }
                            };
        }else{
            Files.createFile(file);
            System.out.println("File created: "+file.getFileName());
           return new ObjectOutputStream(Files.newOutputStream(file,StandardOpenOption.WRITE));
        }
    }
    private static ArrayList<Message> readAllMessages(Path file){
        ArrayList<Message> listMessages= new ArrayList<>();
        if(Files.exists(file)){
            try(
                ObjectInputStream input=new ObjectInputStream(Files.newInputStream(file,StandardOpenOption.READ));
            ){
                while(true){
                    Object obj=input.readObject();
                    System.out.println("Message read: "+obj);
                    listMessages.add(((Message)obj));
                }
            } catch(EOFException e){
                System.out.println("messages retrieved:" + listMessages);
            }
            catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(RemoteImpl.class.getName()).log(Level.WARNING, "Failed reading file", ex);
            }
            try{
                System.out.println("Deleting file: "+file.getFileName());
                Files.deleteIfExists(file);
            }catch (IOException ex) {
                Logger.getLogger(RemoteImpl.class.getName()).log(Level.WARNING, "Failed cleaning inbox", ex);
            }
            System.out.println(listMessages+"messages retrieved from: "+file.getFileName());
        }
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

    /**
     *
     * @return
     * @throws RemoteException
     */
    @Override
    public List<String> getUsers() throws RemoteException {
        return this.listUser;
    }

    @Override
    public void logOut(String username) throws Exception {
//        Path file=Paths.get(username+".inbox");
//        Files.deleteIfExists(file);
        listUser.remove(username);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatrmi.impl;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import chatrmi.remote.InterfaceChat;
/**
 *
 * @author lheredia
 */
public class RemoteImpl extends UnicastRemoteObject implements InterfaceChat {
    String username;
    public RemoteImpl() throws RemoteException{
        super();
    }
    public boolean isLoginValid(String username) throws RemoteException{
        //if (username.equals("test")){
        this.username = username;
            return true;
        //}
        //return false;
    }

    @Override
    public String getUsername() throws Exception {
        return this.username;
    }

    @Override
    public void setUsername() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InterfaceChat getClient() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setClient(InterfaceChat c) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void send(String msg) throws RemoteException {
        System.out.println(msg);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String receive() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

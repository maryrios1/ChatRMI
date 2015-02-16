/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatrmi.impl;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import chatrmi.remote.InterfServer;
/**
 *
 * @author lheredia
 */
public class RemoteImpl extends UnicastRemoteObject implements InterfServer {
    public RemoteImpl() throws RemoteException{
        super();
    }
    public boolean isLoginValid(String username) throws RemoteException{
        if (username.equals("test")){
            return true;
        }
        return false;
    }

    @Override
    public String getUsername() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUsername() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void send(String msg) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean login(String username) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

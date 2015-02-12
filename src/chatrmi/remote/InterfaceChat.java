/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatrmi.remote;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author lheredia
 */
public interface InterfaceChat  extends Remote{
    public boolean isLoginValid(String username) throws Exception;
    public String getUsername() throws Exception;
    public void setUsername() throws Exception;
    public void send(String msg) throws RemoteException;
    public String receive() throws RemoteException;
    public InterfaceChat getClient() throws RemoteException;
    public void setClient(InterfaceChat c)throws RemoteException;
}

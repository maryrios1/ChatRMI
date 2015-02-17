/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatrmi.remote;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lheredia
 */
public interface InterfaceChat  extends Remote{
    public String isLoginValid(String username) throws Exception;
    public String getUsername() throws Exception;
    public void setUsername(String oldName,String newName) throws Exception;
    public void send(String usr,String msg) throws RemoteException;
    public String receive() throws RemoteException;
    public void getStatus(String msg)throws RemoteException;
    public void sendAll(Message msg)throws RemoteException;
    public List<Message> getMessage()throws RemoteException;
}

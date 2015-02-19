package chatrmi.remote;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
/**
 *  Interfaz de comunicacion cliente - server
 * 
 *  @author Mary Carmen Ríos Ramírez
 *  @author Laura Lizeth Heredia Manzano 
 *  @author Carlos Iván Castillo Sepúlveda
 *  @since 2015
 * 
 */
public interface InterfaceChat  extends Remote{
    public String isLoginValid(String username) throws Exception;
    public void logOut(String username) throws Exception;
    public String getUsername() throws Exception;

    /**
     * Sends a message to the server
     * @param msg message to send
     * @throws RemoteException
     */
    public void send(Message msg) throws RemoteException;
    public List<Message> getMessage(String user)throws RemoteException;
    public List<String> getUsers() throws RemoteException;   
}

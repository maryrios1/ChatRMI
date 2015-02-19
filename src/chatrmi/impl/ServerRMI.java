package chatrmi.impl;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import chatrmi.remote.Constants;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 *  @author Mary Carmen Ríos Ramírez
 *  @author Laura Lizeth Heredia Manzano 
 *  @author Carlos Iván Castillo Sepúlveda
 *  @since 2015
 * 
 */
public class ServerRMI {
    public static void main(String[] args) {
        try {
            ServerRMI s = new ServerRMI();
            s.init();
        } catch (RemoteException | AlreadyBoundException ex) {
            Logger.getLogger(ServerRMI.class.getName()).log(Level.SEVERE, "Server cannot start", ex);
        }  
       
    }
    public void init()throws RemoteException, AlreadyBoundException{
        RemoteImpl impl = new RemoteImpl();
        Registry registry = LocateRegistry.createRegistry(Constants.RMI_PORT);
        registry.bind(Constants.RMI_ID, impl);
        System.out.println("Listening users...");
        JOptionPane.showMessageDialog(null, "Server started", "InfoBox: " + "Server", JOptionPane.INFORMATION_MESSAGE); 
    }
}

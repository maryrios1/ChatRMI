/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatrmi.impl;

import chatrmi.remote.Constants;
import chatrmi.remote.InterfaceChat;
import chatrmi.remote.Message;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

/**
 *
 *  @author Mary Carmen Ríos Ramírez
 *  @author Laura Lizeth Heredia Manzano 
 *  @author Carlos Iván Castillo Sepúlveda
 *  @since 2015
 * 
 */
public class ClientRMI {
    final String HOST="localhost";
    static Registry registry;// = LocateRegistry.getRegistry("localhost", Constants.RMI_PORT);
    static InterfaceChat remote;// = (InterfaceChat) registry.lookup(Constants.RMI_ID);

    public ClientRMI() throws RemoteException, NotBoundException, Exception{
        registry = LocateRegistry.getRegistry(HOST, Constants.RMI_PORT);
        remote = (InterfaceChat) registry.lookup(Constants.RMI_ID);
    }
    
    public String isLoginValid(String user) throws Exception{
        return remote.isLoginValid(user);
    }
    
    public List<Message> getMesssages(String user) throws Exception{
        //List<Message> listMessage = remote.getMessage();
        return remote.getMessage(user);
    }
    
    public void sendMessage(Message msg) throws RemoteException{
        remote.send(msg);
    }
    
    public void logOut(String user) throws RemoteException, Exception{
        remote.logOut(user);
    }
    
    public List<String> getUsers() throws RemoteException, Exception{
        return remote.getUsers();
    }
}

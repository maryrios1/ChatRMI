/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatrmi.impl;

import chatrmi.remote.Constants;
import chatrmi.remote.InterfaceChat;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 *  @author Mary Carmen Ríos Ramírez
 *  @author Laura Lizeth Heredia Manzano 
 *  @author Carlos Iván Castillo Sepúlveda
 *  @since 2015
 * 
 */
public class ClientRMI {
    static Registry registry;// = LocateRegistry.getRegistry("localhost", Constants.RMI_PORT);
    static InterfaceChat remote;// = (InterfaceChat) registry.lookup(Constants.RMI_ID);
    
    public ClientRMI() throws RemoteException, NotBoundException, Exception{
        registry = LocateRegistry.getRegistry("localhost", Constants.RMI_PORT);
        remote = (InterfaceChat) registry.lookup(Constants.RMI_ID);
        System.out.println();
        System.out.println(remote.isLoginValid("test"));
        //remote.send();
    }
    
    public boolean isLoginValid(String user) throws Exception{
        return remote.isLoginValid(user);
    }
}

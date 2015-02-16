/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatrmi.impl;

import chatrmi.remote.Constants;
import java.rmi.AlreadyBoundException;
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
public class ServerRMI  {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException{
        RemoteImpl impl = new RemoteImpl();
        
        Registry registry = LocateRegistry.createRegistry(Constants.RMI_PORT);
        registry.bind(Constants.RMI_ID, impl);
        System.out.println("Server is started");
    }
}

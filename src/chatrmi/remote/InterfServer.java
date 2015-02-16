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
 *  @author Mary Carmen Ríos Ramírez
 *  @author Laura Lizeth Heredia Manzano 
 * 
 *  @author Carlos Iván Castillo Sepúlveda
 *  @since 2015
 * 
 */
public interface InterfServer extends Remote{
    public boolean isLoginValid(String username) throws Exception;
    public boolean login(String username) throws Exception;
    public String getUsername() throws Exception;
    public void setUsername() throws Exception;
    public void send(String msg) throws RemoteException;
    
}

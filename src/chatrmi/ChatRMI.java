/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatrmi;

import chatrmi.impl.*;
import chatrmi.ui.LoginChat;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *  @author Mary Carmen Ríos Ramírez
 *  @author Laura Lizeth Heredia Manzano 
 *  @author Carlos Iván Castillo Sepúlveda
 *  @since 2015
 * 
 */
public class ChatRMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(args[0].equals("server")){
            try {
                ServerRMI s = new ServerRMI();
                s.init();
            } catch (RemoteException ex) {
                Logger.getLogger(ChatRMI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (AlreadyBoundException ex) {
                Logger.getLogger(ChatRMI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }if(args[1].equals("cliente")){
            LoginChat x =  new LoginChat();
            x.setVisible(true);
            //x =  new LoginChat();
           // x.setVisible(true);
        }
        // TODO code application logic here
    }
    
}

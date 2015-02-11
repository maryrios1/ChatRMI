/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatrmi.remote;

import chatrmi.impl.ClientRMI;

/**
 *
 * @author lheredia
 */
public class Message implements Runnable {
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ClientRMI getClient() {
        return client;
    }

    public void setClient(ClientRMI client) {
        this.client = client;
    }
    ClientRMI client;

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

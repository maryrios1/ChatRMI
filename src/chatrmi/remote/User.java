/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatrmi.remote;

import java.io.Serializable;

/**
 *
 * @author mary
 */
public class User implements Serializable{
    String usr;
    
    public User(String usr){
        this.usr = usr;
    }
    
    public String getUser(){
        return this.usr;
    }
    
    public void setUser(String usr){
        this.usr = usr;
    }
    
}

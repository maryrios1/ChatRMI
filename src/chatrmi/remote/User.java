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
    String color;
    String status;
    
    public User(String usr,String color,String status){
        this.usr = usr;
        this.color = color;
        this.status = status;
    }
    
    public String getUser(){
        return this.usr;
    }
    
    public void setUser(String usr){
        this.usr = usr;
    }
    
    public String getColor(){
        return this.color;
    }
    
    public void setColor(String clr){
        this.color = clr;
    }
    
    public String getStatus(){
        return this.status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
}

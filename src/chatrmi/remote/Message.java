/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatrmi.remote;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author mary
 */
public class Message implements Serializable,Runnable{
    String UserName;
    String Message;
    Date TimeSend;
    
    public Message(String usr, String msg ){
        this.UserName = usr;
        this.Message = msg;
        this.TimeSend = new Date();
    }
    
    public String getMessage(){
        return this.Message;
    }
    
    public void setMessage(String msg){
        this.Message = msg;
    }
    
    public String getUser(){
        return this.UserName;
    }
    
    public void setUser(String usr){
        this.UserName = usr;
    }
    
    public Date getTime(){
        return this.TimeSend;
    }
    
    public long getTimeAfterSend(){
        return getDateDiff(this.TimeSend,TimeUnit.MILLISECONDS);
    }
    
    /**
     * Get a diff between two dates
     * @param date1 the oldest date
     * @param timeUnit the unit in which you want the diff
     * @return the diff value, in the provided unit
     */
    public static long getDateDiff(Date date1, TimeUnit timeUnit) {
        Date date2 =  new Date();
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

package chatrmi.remote;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 *  @author Mary Carmen Ríos Ramírez
 *  @author Laura Lizeth Heredia Manzano 
 *  @author Carlos Iván Castillo Sepúlveda
 *  @since 2015
 * 
 */
public class Message implements Serializable,Runnable{
    private String UserName;
    private String Message;
    private Date TimeSend;
    private String Type;
    
    public Message(String usr, String msg,String type ){
        this.UserName = usr;
        this.Message = msg;
        this.TimeSend = new Date();
        this.Type = type;
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
    
    public void setType(String type){
        this.Type = type;
    }
    
    public String getType(){
        return this.Type;
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
    public String toString() {
        return "Message{" + "UserName=" + UserName + ", Message=" + Message + '}';
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

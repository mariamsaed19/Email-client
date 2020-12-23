package com.example.emailclient.Email;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public abstract class Email implements Cloneable, Serializable {

    protected String body;
    protected String from;
    protected Date date;
    protected Queue to= new LinkedList();
    protected String subject;
    protected int index;
    protected int key;

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public void setMailindex(int b){
        this.index=b;
    }
    protected  int getMailindex(){return index;}
    protected void setBody(String b){
        this.body=b;
    }
    protected void setFrom(String f){
        this.from=f;
    }
    protected void setDate(Date d){
        this.date=d;
    }
    protected void setSubject(String s){
        this.subject=s;
    }
    protected void setTo(Queue t){
        this.to=t;
    }
    public String getBody(){
        return body;
    }
    public String getFrom(){
        return from;
    }
    public Date getDate(){
        return date;
    }
    public String getSubject(){
        return subject;
    }
    public Queue getTo(){
        return to;
    }
    protected Email getEmail() throws CloneNotSupportedException {
        return (Email)this.clone();
    }
    public abstract Boolean sendEmail(Email e) throws CloneNotSupportedException, IOException;
    public abstract Email composeEmail(Map<String, String> M) throws CloneNotSupportedException;
    abstract Boolean Copy(Email [] e, String source, String destination,String email);
    abstract Boolean DeleteEmail(Email [] e, String source,String email);
    abstract int getIndex(String Foldername , String username);
    abstract void setIndex(String Foldername , String username) throws IOException;
    abstract Email[] Filtering(Email[] emails, String Key, String mode);
    abstract Map<String,Email> getMails(int page, String foldername, String email) throws IOException;
}
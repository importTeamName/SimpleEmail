//package com.importteamname.simpleemail;

import java.time.LocalDateTime;
import java.util.Vector;
/**
 * Holds a email message and related information
 * @author Daniel Weber
 */
public class Message {
	// public Address sender;    // Address not implemented yet
    // public Address receiver;  // Address not implemented yet
    public String subject;
    public LocalDateTime date;
    public String text;
    public boolean markedForDelete; // used for deleting permanately from trash
    public int id;
    public Account sender;
    public Vector<String> receivers = new Vector<String>();

    // constructor
    public Message(String subject, LocalDateTime date, String text,Account sender, Vector<String> Recievers) {
        this.subject = subject;
        this.date = date;
        this.text = text;
        this.markedForDelete = false;
        this.id = text.hashCode();
        this.sender = sender;
        for(String a : Recievers)
        {
        	this.receivers.add(a);
        }
    }

    // Not implemented yet

     public Account getSender()
     {
         return this.sender;
     }
     /**
      * @param sender Account to send to 
      */
     public void setSender(Account sender)
     {
         this.sender = sender;
     }
     /**
      * 
      * @return List of all accounts the message will go to
      */
     public Vector<String> getReceivers()
     {
         return this.receivers;
     }
     /**
      * @param receiver List of accounts the message will go to
      */
    public void addReceiver(String receiver)
    {
        this.receivers.add(receiver);
    }

    /**
     * 
     * @return subject of the message
     */
    public String getSubject()
    {
        return this.subject;
    }
    /**
     * 
     * @param subject subject of the message
     */
    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public LocalDateTime getDate()
    {
        return this.date;
    }

    public void setDate(LocalDateTime date)
    {
        this.date = date;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public boolean getMarkedForDelete()
    {
        return markedForDelete;
    }

    public void setMarkedForDelete(boolean markedForDelete)
    {
        this.markedForDelete = markedForDelete;
    }

    public int getId()
    {
        return id;
    }
}
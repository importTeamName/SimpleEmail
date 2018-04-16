package com.importteamname.simpleemail;

import java.time.LocalDateTime;
import java.util.Vector;
/**
 * Holds a email message and related information
 * @author Daniel Weber, Ben Lanier, Clay Turner
 */
public class Message {
    public String subject;
    public LocalDateTime date;
    public String text;
    public Account sender;
    public Vector<String> receivers = new Vector<String>();

    /**
     * Contructor for creating a new message
     * @param subject String subject of message
     * @param date LocalDateTime timestamp of message
     * @param text String body of message
     * @param sender Account sender of message
     * @param Recievers String Vector of receivers
     */
    public Message(String subject, LocalDateTime date, String text,Account sender, Vector<String> Recievers) {
        this.subject = subject;
        this.date = date;
        this.text = text;
        this.sender = sender;
        for(String a : Recievers)
        {
        	this.receivers.add(a);
        }
    }

    /**
     * Get the sender Account for this message
     * @return Account that sent the message
     */
     public Account getSender()
     {
         return this.sender;
     }
     /**
      * Get the list of recievers
      * @return string vector of all receivers
      */
     public Vector<String> getReceivers()
     {
         return this.receivers;
     }
     
    
    /**
     * Get the list of receivers of the message
     * @return comma separated string of receivers
     */
    public String getReceiversString() {
    	String str = receivers.get(0);
    	for (int i = 1; i < receivers.size(); i++) {
    		str = str + "," + receivers.get(i);
    	}
    	return str;
    }

    /**
     * Get the subject of the message as a string
     * @return String subject of the message
     */
    public String getSubject()
    {
        return this.subject;
    }
    /**
     * Get the time stamp of the message
     * @return LocalDateTime timestamp
     */
    public LocalDateTime getDate()
    {
        return this.date;
    }

    /**
     * Get the message text
     * @return String text of message
     */
    public String getText()
    {
        return text;
    }
}
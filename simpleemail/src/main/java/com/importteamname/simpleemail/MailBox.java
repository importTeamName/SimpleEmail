//package com.importteamname.simpleemail;

import java.util.ArrayList;
/**
 * Stores messages and fetches data from the remote site
 * @author Daniel Weber, Ben Lanier
 *
 */
public class MailBox {
	public String name;
    public ArrayList<Message> messages;

    /**
     * Constructor
     * @param name Name of the MailBox
     */
    public MailBox(String name) {
        this.name = name;
        messages = new ArrayList<Message>();
    }


    /**
     * Returns the name of the mailbox
     * @return The name of the MailBox
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the mailbox
     * @param name The new name for the MailBox
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * For adding messages to mailbox
     * @param m The message to add
     */
    public void addMessageToMailBox(Message m)
    {
    	messages.add(m);
    }
    
    /**
     * Deletes the message from the mailbox
     * @ param m the message to delete
     */
    public void deleteMessageFromMailBox(Message m)
    {
    	messages.remove(m);
    }
    
    /**
     * Return the ArrayList of messages in this mailbox
     * @return the arraylist of messages
     */
    public ArrayList<Message> getMessages(){
    	return messages;
    }

}
package com.importteamname.simpleemail;

import java.util.Vector;
/**
 * Stores information relevant to a single account
 * @author Benjamin Lanier
 */

public class Account {
	private Vector<MailBox> mailBoxList = new Vector<MailBox>();
	
	private String accountname;

	/**
	 * Constructor for the account class
	 * -creates an account with an accountname and password
	 * -creates three mailboxes to start with
	 * @param user account name
	 * @param pass account password
	 */
	public Account(String user)
	{
		accountname = user;
		mailBoxList.add(new MailBox("Sent"));
		mailBoxList.add(new MailBox("Inbox"));
		mailBoxList.add(new MailBox("Trash"));
	}
	
	/**
	 * Getter function for accountname
	 * @return the string account name
	 * 
	 */
	public String getAccountname()
	{
		return accountname;
	}
	
	/**
	 * Adds messages to this account
	 * -iterates through mailboxes in this account to add it to the right mailbox
	 * -the mailbox is where the actual list of messages is stored
	 * @param newMesg Message to be added
	 */
	public void addMessageToAccount(Message newMesg)
	{
		for(MailBox m : mailBoxList)
		{
			if(m.getName().equals("Inbox"))
			{
				m.addMessageToMailBox(newMesg);
			}
		}
	}
	
	/**
	 * Gets the Inbox for this account
	 * @return instance of the Inbox of this account
	 */
	public MailBox getInbox()
	{
		for(MailBox m : mailBoxList)
		{
			if(m.getName().equals("Inbox"))
			{
				return m;
			}
		}
		return null;
	}
	/**
	 * Gets the Trash for this account
	 * @return instance of the trash of this account
	 */
	public MailBox getTrash()
	{
		for(MailBox m : mailBoxList)
		{
			if(m.getName().equals("Trash"))
			{
				return m;
			}
		}
		return null;
	}
	/**
	 * Gets the Sent for this account
	 * @return instance of the sent of this account
	 */
	public MailBox getSent()
	{
		for(MailBox m : mailBoxList)
		{
			if(m.getName().equals("Sent"))
			{
				return m;
			}
		}
		return null;
	}
}
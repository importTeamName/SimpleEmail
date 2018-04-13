//package com.importteamname.simpleemail;

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
	 *  Method for creating new mailboxes
	 * -Intakes a string for the name of new mailbox
	 * @param mailboxname name of new mailbox
	 */
	public void addMailbox(String mailboxname)
	{
		mailBoxList.add(new MailBox(mailboxname));
	}
	
	/**
	 * Method for removing mailboxes
	 * -inputs a string to search for the mailbox to remove
	 * -does not allow removal of the three initial mailboxes
	 * @param mailboxname name of mailbox to remove
	 */
	public void deleteMailbox(String mailboxname)
	{
		if(mailboxname.equals("Inbox") || mailboxname.equals("Trash") || mailboxname.equals("Sent"))
		{
			return;
		}
		int i = 0;
		for(MailBox m : mailBoxList)
		{
			if(m.getName().equals(mailboxname))
			{
				mailBoxList.remove(i);
			}
			i++;
		}
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
//package com.importteamname.simpleemail;

import java.util.Vector;

/**
 * Class for the Remote Site for the SimpleEmail system
 * @author Benjamin Lanier
 */
public class RemoteSite {

	public Vector<User> users;
	
	public RemoteSite()
	{
		users = new Vector<User>();
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean userExists(String userName)
	{
		for( User u : users)
		{
			System.out.println("list: " + u.getUserName() + "  test: " + userName);
			if(u.getUserName().equals(userName))
			{
				System.out.println("User exists");
				return true;
			}
		}
		System.out.println();
		return false;
	}
	
	public boolean validatePassword(String tempUser, String tempPass)
	{
		for( User u : users)
		{
			if(u.getUserName().equals(tempUser))
			{
				if(u.getPassword().equals(tempPass))
				{
					System.out.println("Password matches");
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * This is the function that gets called when a new user is created
	 * @param username new users username
	 * @param pass new users password
	 */
	public void createUser(String username, String pass)
	{
		this.users.add(new User(username,pass));
	}
	
	/**
	 * When a user is deleted it must be deleted here
	 * -the 'Master' instance of a user is held here
	 * @param userToRemove The username to be deleted
	 */
	public void removeUser(String userToRemove)
	{
		int i = 0;
		int indexOfRemove =0;
		for(User tempUser: users)
		{
			if(tempUser.getUserName().equals(userToRemove))
			{
				indexOfRemove = i;
				break;
			}
			i++;
		}
		users.remove(indexOfRemove);
	}
		
	/*This function will act as a 'listener' to receive messages and send them to the correct accounts
	 */
	public void addMessage(Message m)
	{
		Vector<String> rec = m.getReceivers();
		// For each user there is 
		for(User tempUser : users)
		{
			// For each account in that user
			for(Account userAcc : tempUser.getAccounts())
			{
				//For each account the message is being sent to 
				for(String destAccs : rec)
				{
					System.out.println(destAccs);
					if(destAccs.equals(userAcc.getAccountname()))
					{
						tempUser.addMessageToUser(userAcc, m);
					}
				}
				
			}
		}
	}
	/**
	 * When a user logs on they must fetch all data that arrived when they were logged off
	 * When they are logged on, the localsite will update as new info comes in
	 * This remoteSite will also update regardless to if the user is logged in or not
	 *
	* Returns users mailbox of messages recieved while they were logged off
	 * - called by local site on its creation
	 * @param tempUser user that is fetching its inboxes
	 * @return a Vector list of inboxes for all accounts
	 */
	public Vector<Account> getUsersAccounts(User tempUser)
	{
		//Vector<MailBox> usersMailboxes = new Vector<MailBox>();
		Vector<Account> tempAccounts = new Vector<Account>();
		for(User u : users)
		{
			if(u.getUserName().equals(tempUser.getUserName()))
			{
				tempAccounts = u.getAccounts();
				//for(Account accountsInUser : u.getAccounts())
				//{
					//usersMailboxes.add(accountsInUser.getInbox());
				//}
			}
		}
		//The return vector will be a list of all inboxes for each account of the input user
		return tempAccounts;
	}
	
	public User getUser(String userName)
	{
		for(User u: users)
		{
			if(u.getUserName().equals(userName)){
				return u;
			}
		}
		return (User)null;
	}
}
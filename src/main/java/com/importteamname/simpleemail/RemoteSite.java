package com.importteamname.simpleemail;

import java.util.Vector;

/**
 * Class for the Remote Site for the SimpleEmail system
 * @author Benjamin Lanier, Daniel Weber, Alex Porter, Clay Turner
 */
public class RemoteSite {

	public Vector<User> users;
	
	/**
	 * Constructor
	 */
	public RemoteSite()
	{
		users = new Vector<User>();
	}
	
	/**
	 * Checks whether or a user exists
	 * @param userName Name of the user to check for
	 * @return true if the user exists
	 */
	public boolean userExists(String userName)
	{
		for( User u : users)
		{
			if(u.getUserName().equals(userName))
			{
				return true;
			}
		}
		return false;
	}
	/**
	 * Check whether or not password is correct for the given user
	 * @param tempUser User to check password for
	 * @param tempPass Password to check for correctness
	 * @return true is the password is correct
	 */
	public boolean validatePassword(String tempUser, String tempPass)
	{
		for( User u : users)
		{
			if(u.getUserName().equals(tempUser))
			{
				if(u.getPassword().equals(tempPass))
				{
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
	 * Deletes a user from the list of users
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
		
	/**
	 * Gets all the users being stored
	 * @return a Vector of the Users 
	 */
	public Vector<User> getUsers()
	{
		return users;
	}
	/**
	 * Gets all the accounts for a given User
	 * @param tempUser user that is fetching its accounts
	 * @return a Vector of the accounts 
	 */
    public Vector<Account> getUsersAccounts(User tempUser)

	{
        Vector<Account> tempAccounts = new Vector<Account>();
        if (tempUser == null) {
            return tempAccounts;
        }
		for(User u : users)
		{
			if(u.getUserName().equals(tempUser.getUserName()))
			{
				tempAccounts = u.getAccounts();
			}
		}
		return tempAccounts;
	}
	
	/**
	 * Gets a user that is specfied by name
	 * @param userName String name of the specified user
	 * @return User object for the given name
	 */
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
	
	/**
	 * Checks if a account name is unique
	 * @return returns false if name already exists
	 */
	public boolean UniqueCheck(String nameToCheck) {
		for(User u: users) {
			for(Account a : u.getAccounts()) {
				if (a.getAccountname().equals(nameToCheck)) {
					return false;
				}
			}
		}
		return true;
    }
    
    /**
     * Add message to recipient's inbox
     * @param message: Message to be sent to recipients
     */
    public void addMessageToRecipientsInbox(Message message) {

        for (String rec : message.getReceivers()) {
            for(User user : this.users) {
                for (Account acc: user.getAccounts()) {
                    if (acc.getAccountname().equals(rec)) {
                        MailBox inbox = acc.getInbox();
                        inbox.addMessageToMailBox(message);
                    }
                }
            }
        }
    }
    
}
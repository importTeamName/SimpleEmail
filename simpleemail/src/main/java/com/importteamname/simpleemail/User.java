//package com.importteamname.simpleemail;

import java.util.Vector;

/**
 * Stores information relevant to a single account
 * @author Benjamin Lanier, Daniel Weber
 */
public class User {
	private String username;
	private String password;
	private Vector<Account> accounts = new Vector<Account>();
	
	/**
	 * Constructor to create a new User
	 * -User is created with a password and username
	 * -starts with two accounts (user@local, user@remote)
	 * @param user Users login username
	 * @param pass Users password
	 */
	public User(String user, String pass){
		username = user;
		password = pass;
		accounts.add(new Account(user+"@local"));
		accounts.add(new Account(user+"@remote"));
	}
	
	/**
	 * Get the username of the user
	 * @return String name of user
	 */
	public String getUserName(){
		return username;
	}
	
	 /**
	  * Method to add accounts to this user
	  * @param accName the name of the new account (before @ symbol)
	  * @param suffix extension of the email (after @ symbol)
	  * @param accPass password of the newly created account
	  */
	public void addAccount(String accName, String suffix){
		accounts.add(new Account(accName + suffix));
	}
	/**
	 * Removes an account from this user
	 * @param accName String name of account to remove
	 */
	public void removeAccount(String accName)
	{
		int i = 0;
		boolean accFound = false;
		for(Account a : accounts){
			if(a.getAccountname().equals(accName)){
				accFound = true;
				break;
			}
				
		}
		if(accFound){
			accounts.remove(i);
		}
	}
	/**
	 * Returns the list of account associated with this user
	 * @return
	 */
	public Vector<Account> getAccounts()
	{
		return accounts;
	}
	/**
	 * Returns a specific account in this user specified by name
	 * @param name String name of account to get 
	 * @return Account object if found, null if no matching account
	 */
	public Account getAccount(String name) {
		for (Account a : accounts) {
			if (a.getAccountname().equals(name)) {
				return a;
			}
		}
		return null;
	}
	/**
	 * Searches accounts Associated to the user to find the right account
	 * -calls addMessageToAccount so the account can add it to the right mailbox
	 * @param a account to send message to 
	 * @param m message that is being sent
	 */
	public void addMessageToUser(Account a, Message m)
	{
		for(Account acc : accounts)
		{
			if(acc.getAccountname().equals(a))
			{
				acc.addMessageToAccount(m);
			}
		}
	}

	/**
	 * Gets the Password of this User
	 * @return String password of this User
	 */
	public String getPassword() {
		return password;
	}
}
/**
 * Stores information relevant to a single account
 * @author Benjamin Lanier
 *
 */
import java.util.Vector;

public class User {
	private String username;
	private String password;
	private Vector<Account> accounts = new Vector<Account>();
	
	/**
	 * 	 * User is created with a password and username
	 * -starts with two accounts (user@uah.edu, user@uah.com);
	 * -both accounts are created with the same password as user
	 * -passwords can be changed in the future
	 * 
	 * @param user Users login username
	 * @param pass Users password
	 */
	public User(String user, String pass){
		username = user;
		password = pass;
		accounts.add(new Account(user+"@uah.edu", pass));
		accounts.add(new Account(user+"@uah.com", pass));
	}
	
	/*Getter for username
	 */
	public String getUserName(){
		return username;
	}
	/*Setter for password
	 */
	public void setPassword(String newPass){
		password = newPass;
	}
	
	 /**
	  * 	 *  Method to add accounts to this user
	  * @param accName the name of the new account (before @ symbol)
	  * @param suffix extension of the email (after @ symbol)
	  * @param accPass password of the newly created account
	  */
	public void addAccount(String accName, String suffix, String accPass){
		accounts.add(new Account(accName+"@"+suffix, accPass));
		
		for(Account a : accounts)
		{
			System.out.println("Acc: " + a.getAccountname());
		}
	}
	public void removeAccount(String accName)
	{
		int i = 0;
		boolean accFound = false;
		for(Account a : accounts)
		{
			if(a.getAccountname().equals(accName))
			{
				accFound = true;
				break;
			}
				
		}
		if(accFound)
		{
			accounts.remove(i);
		}
		
		for(Account a : accounts)
		{
			System.out.println("Acc: " + a.getAccountname());
		}
	}
	/*Gets list of accounts associated with user
	 * 
	 */
	public Vector<Account> getAccounts()
	{
		return accounts;
	}
	/**
	 * 	 * Searches accounts Associated to the user to find the right account
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

	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
}

package com.importteamname.simpleemail;
import org.junit.Test;
import org.junit.Assert;

import java.util.Vector;

/**
 * Tests for {@link RemoteSite}.
 * 
 * @author: Daniel Weber
 */
public class RemoteSiteTest {

    private Helper helper = new Helper();
    private RemoteSite remoteSite = new RemoteSite();
    private User alice = new User("Alice", "password");
    private User bob = new User("Bob", "password");
    private User charlie = new User("Charlie", "password");
    private Vector<User> users = new Vector<User>();


    public RemoteSiteTest() {
        users.add(alice);
        users.add(bob);
        users.add(charlie);
        remoteSite.users = users;
    }


    @Test
    public void userExistsTest() {
        Assert.assertTrue(remoteSite.userExists("Alice"));
        Assert.assertTrue(remoteSite.userExists("Bob"));
    }


    @Test
    public void validatePasswordTest() {
        Assert.assertTrue(!remoteSite.validatePassword("Alice", "wrongPassword"));
        Assert.assertTrue(remoteSite.validatePassword("Alice", "password"));
    }

    
    @Test
    public void createUserTest() {
        remoteSite.createUser("David", "password");
        Assert.assertTrue(remoteSite.getUser("David") != null);

        remoteSite.createUser("Erin", "slightlyBetterPassword");
        Assert.assertTrue(remoteSite.getUser("Erin") != null);
    }


    @Test
    public void removeUserTest() {
        remoteSite.removeUser("Alice");
        Assert.assertTrue(!remoteSite.users.contains(alice));

        remoteSite.removeUser("Bob");
        Assert.assertTrue(!remoteSite.users.contains(bob));
    }


    @Test
    public void getUsersAccountsTest() {
        Vector<Account> actualAccounts = remoteSite.getUsersAccounts(alice);
        Vector<Account> expectedAccounts = new Vector<Account>();
        expectedAccounts.add(new Account("alice@local"));
        expectedAccounts.add(new Account("alice@remote"));
        Assert.assertTrue(helper.equalAccounts(actualAccounts, expectedAccounts));
    }


    @Test 
    public void getNullUsersAccountsTest() {
        Vector<Account> actualAccounts = remoteSite.getUsersAccounts((User)null);
        Vector<Account> expectedAccounts = new Vector<Account>();
        Assert.assertTrue(helper.equalAccounts(actualAccounts, expectedAccounts));
    }


    @Test
    public void getNullUserTest() {
        Assert.assertEquals(remoteSite.getUser(""), null);
    }


    @Test
    public void uniqueCheckTest() {
        remoteSite.createUser("Frank", "password");
        Assert.assertTrue(!remoteSite.UniqueCheck("Frank@local"));
        Assert.assertTrue(remoteSite.UniqueCheck("fakeName@fakeDomain"));
    }

    @Test
    public void addMessageToRecipientsInboxTest() {

        // Recipients include bob@remote and charlie@remote
        Message message = helper.createDummyMessage();
        remoteSite.addMessageToRecipientsInbox(message);
        Assert.assertTrue(bob.getAccount("Bob@remote").getInbox().getMessages().contains(message));
        Assert.assertTrue(charlie.getAccount("Charlie@remote").getInbox().getMessages().contains(message));


    }

    
}
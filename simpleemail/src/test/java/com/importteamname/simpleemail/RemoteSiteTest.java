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

    }

    @Test
    public void removeUserTest() {
        remoteSite.removeUser("Alice");
        Assert.assertTrue(!remoteSite.users.contains(alice));
    }

    @Test
    public void getUserAccountsTest() {

        Vector<Account> actualAccounts = remoteSite.getUsersAccounts(alice);
        Vector<Account> expectedAccounts = new Vector<Account>();
        expectedAccounts.add(new Account("alice@local"));
        expectedAccounts.add(new Account("alice@remote"));
        Assert.assertTrue(helper.equalAccounts(actualAccounts, expectedAccounts));

    }

    // @Test
    // public void getUserTest() {

    //     Assert.assertTrue(helper.equalUsers(remoteSite.getUser("Alice"), alice));


    // }



}
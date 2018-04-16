package com.importteamname.simpleemail;

import org.junit.Test;
import org.junit.Assert;

/**
 * Tests for {@link User}.
 * 
 * @author: Daniel Weber
 */
public class UserTest {

    private User alice = new User("Alice", "password");
    private Helper helper = new Helper();

    @Test
    public void newUserShouldHaveLocalandRemoteAccounts() {
        Account expectedLocalAccount = new Account("Alice@local");
        Account expectedRemoteAccount = new Account("Alice@remote");
        Account actualLocalAccount = alice.getAccounts().get(0);
        Account actualRemoteAccount = alice.getAccounts().get(1);

        Assert.assertTrue(helper.equalAccount(actualLocalAccount, expectedLocalAccount));
        Assert.assertTrue(helper.equalAccount(actualRemoteAccount, expectedRemoteAccount));
    }

    @Test
    public void addAccountTest() {
        alice.addAccount("Alice", "@uah.edu");
        Account expectedNewAccount = new Account("Alice@uah.edu");
        Account actualNewAccount = alice.getAccount("Alice@uah.edu");

        Assert.assertEquals(alice.getAccounts().size(), 3);
        Assert.assertTrue(helper.equalAccount(expectedNewAccount, actualNewAccount));
    }

    @Test
    public void removeAccountTest() {
        alice.removeAccount("Alice@local");
        Assert.assertEquals(alice.getAccount("Alice@local"), null);
    }

    @Test
    public void getAccountTest() {
        alice.addAccount("Alice", "@gmail.com");
        Account expectedAccount = new Account("Alice@gmail.com");
        Account actualAccount = alice.getAccount("Alice@gmail.com");
        Assert.assertTrue(helper.equalAccount(expectedAccount, actualAccount));
    }

}
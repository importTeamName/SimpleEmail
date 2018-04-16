package com.importteamname.simpleemail;

import org.junit.Test;
import org.junit.Assert;

/**
 * Tests for {@link Account}.
 * 
 * @author: Daniel Weber
 */
public class AccountTest {

    private Helper helper = new Helper();
    private Account account = new Account("Alice");

    @Test
    public void newAccountShouldHaveInboxWithEmptyMessages() {
        MailBox inbox = new MailBox("Inbox");
        Assert.assertTrue(helper.equalMailboxes(account.getInbox(), inbox));
    }


    @Test
    public void newAccountShouldHaveSentWithEmptyMessages() {
        MailBox sent = new MailBox("Sent");
        Assert.assertTrue(helper.equalMailboxes(account.getSent(), sent));
    }

    @Test
    public void newAccountShouldHaveTrashWithEmptyMessages() {
        MailBox trash = new MailBox("Trash");
        Assert.assertTrue(helper.equalMailboxes(account.getTrash(), trash));
    }

    @Test
    public void addMessageToAccountTest() {

        Message message1 = helper.createDummyMessage();
        account.addMessageToAccount(message1);
        Assert.assertTrue(account.getInbox().getMessages().contains(message1));

        Message message2 = helper.createDummyMessage();
        account.addMessageToAccount(message2);
        Assert.assertTrue(account.getInbox().getMessages().contains(message2));


    }

    @Test
    public void addNullMessageToAccountTest() {

        Message message1 = null;
        try {
            account.addMessageToAccount(message1);
        } catch(Exception e) {
            Assert.fail("addMessageToAccount could not accept a null object");
        }

    }


}
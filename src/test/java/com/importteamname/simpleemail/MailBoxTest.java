package com.importteamname.simpleemail;

import org.junit.Test;
import org.junit.Assert;

/**
 * Tests for {@link MailBox}.
 * 
 * @author: Daniel Weber
 */
public class MailBoxTest {

    private MailBox mailbox = new MailBox("Inbox");
    private Helper helper = new Helper();

    @Test
    public void addMessageToMailBoxTest() {
        Message message = helper.createDummyMessage();
        mailbox.addMessageToMailBox(message);
        
        // Test that new message is in mailbox
        Assert.assertTrue(mailbox.getMessages().contains(message));
    }

    @Test 
    public void addNullMessageToMailBoxTest() {
        Message message = (Message)null;
        try {
            mailbox.addMessageToMailBox(message);
        } catch(Exception e) {
            Assert.fail("addMessageToMailbox could not accept a null object");
        }
    }

    @Test
    public void deleteMessageFromMailBoxTest() {
        Message message = helper.createDummyMessage();
        mailbox.addMessageToMailBox(message);
        mailbox.deleteMessageFromMailBox(message);

        // Test that deleted message is not in mailbox
        Assert.assertTrue(!mailbox.getMessages().contains(message));
    }

    @Test
    public void deleteNullMessageFromMailBoxTest() {
        Message message = (Message)null;
        try {
            mailbox.deleteMessageFromMailBox(message);
        } catch(Exception e) {
            Assert.fail("deleteMessageToMailbox could not accept a null object");
        }
    }

}
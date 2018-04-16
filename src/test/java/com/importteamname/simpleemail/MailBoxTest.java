package com.importteamname.simpleemail;

import org.junit.Test;
import org.junit.Assert;
import java.util.Vector;

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
    public void deleteMessageFromMailBoxTest() {

        Message message = helper.createDummyMessage();
        mailbox.addMessageToMailBox(message);
        mailbox.deleteMessageFromMailBox(message);

        // Test that deleted message is not in mailbox
        Assert.assertTrue(!mailbox.getMessages().contains(message));

    }

}
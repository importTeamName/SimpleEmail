package com.importteamname.simpleemail;

import org.junit.Test;
import org.junit.Assert;
import java.util.Vector;

/**
 * Tests for {@link ComposeMessage}.
 * Nothing to test. All GUI elements.
 * 
 * @author: Daniel Weber
 */
public class ComposeMessageTest {

    private Helper helper = new Helper();
    private RemoteSite remoteSite = new RemoteSite();
    private User alice = new User("Alice", "password");
    private User bob = new User("Bob", "password");
    private User charlie = new User("Charlie", "password");
    private Vector<User> users = new Vector<User>();
    private ComposeMessage cmpMsg;


    public ComposeMessageTest() {
        users.add(alice);
        users.add(bob);
        users.add(charlie);
        remoteSite.users = users;
        cmpMsg = new ComposeMessage(alice.getAccount("Alice@local"), remoteSite);
    }

    @Test
    public void addMessageToRecipientsInboxTest() {

        // Recipients include bob@remote and charlie@remote
        Message message = helper.createDummyMessage();
        cmpMsg.addMessageToRecipientsInbox(message, message.receivers);
        Assert.assertTrue(bob.getAccount("Bob@remote").getInbox().getMessages().contains(message));

    }

}
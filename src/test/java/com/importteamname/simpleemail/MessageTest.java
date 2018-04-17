package com.importteamname.simpleemail;

import org.junit.Test;
import org.junit.Assert;

/**
 * Tests for {@link Message}.
 * 
 * @author: Daniel Weber
 */
public class MessageTest {

    private Helper helper = new Helper();
    private Message message;

    public MessageTest() {
        message = helper.createDummyMessage();
    }

    @Test
    public void getReceiversStringTest() {
    
        String actual = message.getReceiversString();
        String expected = "Bob@gmail.com,Charlie@gmail.com";
        Assert.assertEquals(actual, expected);
    }

}
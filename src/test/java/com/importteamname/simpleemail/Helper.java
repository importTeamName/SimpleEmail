package com.importteamname.simpleemail;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Helper functions to help compare objects for tests
 * 
 * @author: Daniel Weber
 */
public class Helper {


    public boolean equalMailboxes(MailBox a, MailBox b) {

        return a.name.equals(b.name) && 
               equalMessages(a.messages, b.messages);

    }

    public boolean equalMessages(ArrayList<Message> messagesA, ArrayList<Message> messagesB) {
        
        if (messagesA.size() != messagesB.size()) {
            return false;
        }


        for (int i = 0; i < messagesA.size(); i++) {
            if (equalMessage(messagesA.get(i), messagesB.get(i))) {
                return false;
            }
        }

        return true;

    }

    public boolean equalMessage(Message a, Message b) {

        return a.subject.equals(b.subject) &&
               a.date.equals(b.date) &&
               a.text.equals(b.text) &&
               sameReceivers(a.receivers, b.receivers);

    }

    public boolean equalAccount(Account a, Account b) {

        return a.getAccountname().equals(b.getAccountname()) &&
               equalMailboxes(a.getInbox(), b.getInbox()) &&
               equalMailboxes(a.getSent(), b.getSent()) &&
               equalMailboxes(a.getTrash(), b.getTrash());

    }

    public boolean equalAccounts(Vector<Account> accountsA, Vector<Account> accountsB) {

        if (accountsA.size() != accountsB.size()) {
            return false;
        }

        for (int i = 0; i < accountsA.size(); i++) {
            if (equalAccount(accountsA.get(i), accountsB.get(i))) {
                return false;
            }
        }

        return true;

    }

    public boolean equalUsers(User a, User b) {

        return a.getUserName().equals(b.getUserName()) &&
               a.getPassword().equals(b.getPassword()) &&
               equalAccounts(a.getAccounts(), b.getAccounts());

    }

    public boolean sameReceivers(Vector<String> receiversA, Vector<String> receiversB) {
        
        for (String recA : receiversA) {
            if (!receiversB.contains(recA)) {
                return false;
            }
        }

        return true;
    }

    public Message createDummyMessage() {
        
        LocalDateTime date = LocalDateTime.now();
        Account account = new Account("Alice@gmail.com");
        Vector<String> receivers = new Vector<String>();
        receivers.add("Bob@gmail.com");
        receivers.add("Charlie@gmail.com");
        Message message = new Message("Subject", date, "Body of message", account, receivers);
        return message;
    }

    public Message createDummyMessage2() {
        
        LocalDateTime date = LocalDateTime.now();
        Account account = new Account("Erin@gmail.com");
        Vector<String> receivers = new Vector<String>();
        receivers.add("Frank@gmail.com");
        receivers.add("Grace@gmail.com");
        Message message = new Message("Another message", date, "Another body", account, receivers);
        return message;
    }


}
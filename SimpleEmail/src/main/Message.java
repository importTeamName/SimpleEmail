import java.time.LocalDateTime;

public class Message {

    // public Address sender;    // Address not implemented yet
    // public Address receiver;  // Address not implemented yet
    public String subject;
    public LocalDateTime date;
    public String text;
    public boolean markedForDelete; // used for deleting permanately from trash
    public int id;

    // constructor
    public Message(String subject, LocalDateTime date, String text) {
        this.subject = subject;
        this.date = date;
        this.text = text;
        this.markedForDelete = false;
        this.id = text.hashCode();
    }

    // Not implemented yet

    // public Address getSender() {
    //     return this.sender;
    // }

    // public void setSender(Address sender) {
    //     this.sender = sender;
    // }

    // public Address getReceiver() {
    //     return this.receiver;
    // }

    // public void setReceiver(Address receiver) {
    //     this.receiver = receiver;
    // }


    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean getMarkedForDelete() {
        return markedForDelete;
    }

    public void setMarkedForDelete(boolean markedForDelete) {
        this.markedForDelete = markedForDelete;
    }

    public int getId() {
        return id;
    }


}

import java.util.ArrayList;

public class Mailbox {

    public String name;
    public ArrayList<Message> messages;

    // constructor
    public Mailbox(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

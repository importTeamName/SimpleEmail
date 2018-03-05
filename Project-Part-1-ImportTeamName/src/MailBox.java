import java.util.ArrayList;
/**
 * Stores messages and fetches data from the remote site
 * @author Daniel Weber
 *
 */
public class MailBox {
	public String name;
    public ArrayList<Message> messages;

    /**
     * Constructor
     * @param name Name of the MailBox
     */
    public MailBox(String name) {
        this.name = name;
    }


    /**
     * Returns the name of the mailbox
     * @return The name of the MailBox
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the mailbox
     * @param name The new name for the MailBox
     */
    public void setName(String name) {
        this.name = name;
    }


}
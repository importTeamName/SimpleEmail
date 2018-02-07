import java.time.LocalDateTime;

public class MessageTest {

    public static void main(String[] args) {

        Date now = LocalDateTime();
        String text = "The quick brown fox jumped over the lazy dog.";
        Message msg = new Message("Hello!!", now, text);
        
        System.out.println(msg.subject);
        System.out.println(msg.date);   // Not working atm
        System.out.println(msg.text);
        System.out.println(msg.id);

 
    }

}
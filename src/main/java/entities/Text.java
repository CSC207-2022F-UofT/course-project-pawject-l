package entities;
import java.time.LocalDateTime;

public class Text {
    /**
     *A constructor for a text object.
     */
    final String senderID;
    final LocalDateTime timeSent;
    final String messageText;

    public Text(String petID, LocalDateTime timeSent, String messageText){
        this.senderID = petID;
        this.timeSent = timeSent;
        this.messageText = messageText;
    }
}

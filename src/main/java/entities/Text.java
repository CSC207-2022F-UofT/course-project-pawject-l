package entities;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Text implements Serializable {
    private String senderID;
    private LocalDateTime timeSent;
    private String messageText;

    /**
     *A constructor for a text object.
     *
     * @param petID the ID of the pet who sent the text
     * @param timeSent the date and time the text was sent
     * @param messageText the message in the text
     */
    public Text(String petID, LocalDateTime timeSent, String messageText){
        this.senderID = petID;
        this.timeSent = timeSent;
        this.messageText = messageText;
    }

    /**
     * A method that gets the ID of the text's sender
     * @return the petID of the text's sender
     */
    public String getSenderID() {
        return this.senderID;
    }

    /**
     * A method that gets the time and date the text was sent
     * @return the date and time the text was sent
     */
    public LocalDateTime getTimeSent() {
        return this.timeSent;
    }

    /**
     * A method that gets the message of the text
     * @return the message of the text
     */
    public String getMessageText() {
        return this.messageText;
    }
}

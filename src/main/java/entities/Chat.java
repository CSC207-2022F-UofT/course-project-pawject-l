package entities;
import java.util.ArrayList;
import java.util.List;
public class Chat {
    private String chatID;
    private List<Text> conversation;

    /**
     * A constructor that creates a Chat object
     * @param chatID the unique ID of the chat
     */
    public Chat(String chatID){
        this.chatID = chatID;
        this.conversation = new ArrayList<Text>();
    }

    /**
     * A method that gets the chat's ID
     * @return the chatID
     */
    public String getChatID() {
        return this.chatID;
    }

    /**
     * A method that gets the chat's conversation history
     * @return the conversation arrayList of texts
     */
    public List<Text> getConversation() {
        return this.conversation;
    }

    /**
     * A method that adds a text message to the conversation history
     * @param message the message to be sent
     */
    public void addText(Text message){
        this.conversation.add(message);
    }
}

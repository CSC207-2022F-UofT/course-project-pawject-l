package repo;

import entities.User;
import entities.Chat;

import java.util.HashMap;

public interface ChatDataRequestModel {

    /**
     * Get all chats from the database
     * @return Hashmap with keys as the id and values as Chat object
     */
    HashMap<String, Chat> getChats();

    /**
     * Get a chat given the chatID.
     * @param chatID chat ID
     * @return Chat
     */
    Chat getChatByID(String chatID);

    /**
     * Saves chat in database. Returns true if saved, false if not.
     * @param pet1ID, pet2ID, chat
     * @return true if saved, false if not
     */
    boolean saveChat(String pet1ID, String pet2ID, Chat chat);


}

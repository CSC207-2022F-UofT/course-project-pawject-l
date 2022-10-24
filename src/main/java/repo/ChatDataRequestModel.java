package repo;

import entities.User;
import entities.Chat;

import java.util.HashMap;

public interface ChatDataRequestModel {

    Chat getChat(String id);

    /**
     * Get all chats given a user.
     * @param user
     * @return Hashmap with keys as the id and values as Chat object
     */
    HashMap<String, Chat> getChatsByUser(User user);

    /**
     * Get a chat given the user and the other user.
     * @param currUser
     * @param otherUser
     * @return Pet
     */
    Chat getChatByUsers(User currUser, User otherUser);

    /**
     * Saves chat in database. Returns true if saved, false if not.
     * @param chat
     * @return true if saved, false if not
     */
    boolean saveChat(Chat chat);

    // Let me know if you would like other methods (e.g. to get a specific chat).

}

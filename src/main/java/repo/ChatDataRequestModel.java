package repo;

import entities.Pet;
import entities.Chat;

import java.util.ArrayList;

public interface ChatDataRequestModel {
    /**
     * Get all chats given a pet.
     * @param pet pet object
     * @return Hashmap with keys as the chatID and values as Chat object
     */
    ArrayList<Chat> getChats(Pet pet);

    /**
     * Method to return chat by ChatID
     * @param ChatID chatID
     * @return Chat entity corresponding to the chatID
     */
    Chat getChatByID(String ChatID);

    /**
     * Saves chat in database. Returns true if saved, false if not.
     * @param chat
     * @return true if saved, false if not
     */
    boolean saveChat(String petID1, String petID2, Chat chat);

    // Let me know if you would like other methods (e.g. to get a specific chat).

}

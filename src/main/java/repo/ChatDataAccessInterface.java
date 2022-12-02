package repo;

import entities.Chat;
import entities.Text;

import java.io.IOException;
import java.util.ArrayList;

public interface ChatDataAccessInterface {


    /**
     * Get all chats from the database by pet ID
     * @param petID the pet id
     * @return an arraylist of chat entities
     */
    ArrayList<Chat> getChatsByPet(String petID);

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
    boolean saveChat(String pet1ID, String pet2ID, Chat chat) throws IOException;

    /**
     * Saves text into the database
     * @param chatID the chat id
     * @param text the text entity to be saved
     * @throws IOException exception
     */
    void saveText(String chatID, Text text) throws IOException;

}

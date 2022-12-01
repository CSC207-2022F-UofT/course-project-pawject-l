package useCase;// use case layer

import entities.Chat;
import entities.Pet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public interface ChatManagerInputBoundary {
    /**
     * A method that creates a chat and saves it to the database
     * @param p1_id first pet id
     * @param p2_id second pet id
     * @throws IOException exception
     */
    void createChat(String p1_id, String p2_id) throws IOException;

    /**
     * Method that generates an unique chat id
     */
    String generateUniqueChatID();

    /**
    Method that sorts the chatlist
     */
    ArrayList<Chat> generateSortedChatList(ArrayList<Chat> chats);

    /**
     * Method that returns a hashmap of chat id to chat object
     * @param petID pet id
     * @return a hashmap of chatid to chat objects
     */
    HashMap<String, Chat> getChatsByPet (String petID);

    /**
     * returns a chat object by ID
     * @param ChatID
     * @return chat entity
     */
    Chat getChatByID(String ChatID);

    /**
     * Method that gets a list of texts from a chat using its chatID
     * @param chatID the chatID
     * @return a 2d string array of the texts
     */
    String[][] getTextsList(String chatID);

    /**
     * method that saves the text to the csv file
     * @param chatID the chat id
     * @param petID the pet id who sent the message
     * @param message the message
     * @throws IOException exception
     */
    void sendText(String chatID, String petID, String message) throws IOException;



}

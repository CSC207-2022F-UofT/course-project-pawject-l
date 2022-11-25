package useCase;

import entities.Chat;
import entities.Pet;
import repo.ChatDataAccessInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;


public class ChatManager {
    ChatDataAccessInterface CDRM;
    public ChatManager(ChatDataAccessInterface CDRM){
        this.CDRM = CDRM;
    }
    private static long idCounter = 0;

    /**
     * A method that generates a unique Chat ID
     * @return unique chatID
     */
    public static String generateUniqueChatID() {
        return "ChatID" + Long.toString(idCounter++);
    }

    /**
     * A method that sorts a list of chat entities by recency
     * @param chats a list of chat entities
     * @return the list of chat entities sorted by recency of the last text sent
     */
    public ArrayList<Chat> generateSortedChatList(ArrayList<Chat> chats) {
        Collections.sort(chats,
                Comparator.comparing(c-> c.getConversation().get(c.getConversation().size()).getTimeSent()));
        return chats;
    }

    /**
     * A method that creates a chat between two pets
     * @param p1 the first pet in the chat
     * @param p2 the second chat in the chat
     */
    public void createChat(Pet p1, Pet p2){
        Chat newChat = new Chat(generateUniqueChatID());
        CDRM.saveChat(p1.getPetID(), p1.getPetID(), newChat);
    }

    /**
     * A method that returns a hashmap of the chats belonging to the pet
     * @param pet the pet entity
     * @return a hashmap with chatID as keys and chat entities as values
     */
    public HashMap<String, Chat> getChatsByPet (Pet pet) {
        HashMap<String, Chat> listOfChats = new HashMap<>();
        for(Chat chat : CDRM.getChatsByPet(pet)){
            listOfChats.put(chat.getChatID(), chat);
        }
        return listOfChats;
    }

    /**
     * A method that returns the chat with the chatID
     * @param ChatID the chatID
     * @return A chat entity
     */
    public Chat getChatByID(String ChatID) {
        return CDRM.getChatByID(ChatID);
    }


}
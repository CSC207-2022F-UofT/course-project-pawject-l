package userCase;

import entities.Chat;
import entities.Pet;
import entities.Text;
import entities.User;
import repo.ChatDataRequestModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class ChatManager {
    private ChatDataRequestModel CDRM;
    private static long chatIdCounter = 0;

    public ChatManager(ChatDataRequestModel CDRM){
        this.CDRM = CDRM;
    }

    /**
     * A method that sorts a pet's list of chats by time
     * @param chats the list of a pet's chats
     * @return a list of chats sorted by the time the last text was sent, from most recent to oldest
     */
    public ArrayList<Chat> GenerateSortedChatList(ArrayList<Chat> chats) {
        chats.sort(Comparator.comparing(o -> o.getConversation().get(o.getConversation().size()).getTimeSent()));
        return chats;
    }

    /**
     * A method that generates a unique chatID
     * @return a unique chatID
     */
    public static String generateUniqueChatID() {
        return "ChatID" + String.valueOf(chatIdCounter++);
    }

    /**
     * A method that creates a new chat and adds it to the chat-list of both pets
     * @param pet1 the first pet entity
     * @param pet2 the second pet entity
     */
    public void createChat(Pet pet1, Pet pet2) {
        String uniqueChatID = generateUniqueChatID();
        Chat chat = new Chat(uniqueChatID);
        this.CDRM.saveChat(pet1.getPet_id(), pet2.getPet_id(), chat);
    }

    /**
     * A method that takes information from the database and returns a hashmap
     * containing all the chats that belong to a given pet.
     * @param pet the pet for which you want to get the chats
     * @return a hashmap of chatID to Chat entity of the pet
     */
    public HashMap<String, Chat> getChatsByPet(Pet pet){
        HashMap<String, Chat> chatsByPet = new HashMap<String, Chat>;
        for(Chat chat: CDRM.getChats(pet)) {
            chatsByPet.put(chat.getChatID(), chat);
        }
        return chatsByPet;
    }

    /**
     * A method that gets chat by ChatID
     * @param chatID the chat's ID
     * @return the chat object
     */
    public Chat getChatByID(String chatID) {
        return CDRM.getChatByID(chatID);
    }



}

package useCase;// use case layer

import entities.Chat;
import entities.Pet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public interface ChatManagerInputBoundary {
    void createChat(String p1_id, String p2_id) throws IOException;

    String generateUniqueChatID();
    ArrayList<Chat> generateSortedChatList(ArrayList<Chat> chats);

    HashMap<String, Chat> getChatsByPet (String petID);

    Chat getChatByID(String ChatID);

    String[][] getTextsList(String chatID);

    void sendText(String chatID, String petID, String message) throws IOException;



}

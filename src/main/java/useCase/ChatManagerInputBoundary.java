package useCase;// use case layer

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public interface ChatManagerInputBoundary {
    public void createChat(String p1_id, String p2_id) throws IOException;

    public String generateUniqueChatID();
    public ArrayList<Chat> generateSortedChatList(ArrayList<Chat> chats);

    public void createChat(Pet p1, Pet p2) throws IOException;

    public HashMap<String, Chat> getChatsByPet (String petID);

    public Chat getChatByID(String ChatID);

    public String getOtherPetInChat(String firstPet, Chat chat);

    public Chat getChatByPets(String petID1, String petID2);

    public String[][] getTextsList(String chatID);

    public void sendText(String chatID, String petID, String message) throws IOException;



}

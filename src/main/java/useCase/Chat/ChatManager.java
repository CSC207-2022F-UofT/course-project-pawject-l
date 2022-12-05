package useCase.Chat;

import entities.Chat;
import entities.Text;
import repo.ChatDataAccessInterface;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class ChatManager implements ChatManagerInputBoundary {
    static ChatDataAccessInterface CDAI;
    public ChatManager(ChatDataAccessInterface CDAI){
        ChatManager.CDAI = CDAI;
    }
    private static long idCounter = 0;

    /**
     * A method that generates a unique Chat ID
     * @return unique chatID
     */
    public String generateUniqueChatID() {
        return "ChatID" + idCounter++;
    }

    /**
     * A method that sorts a list of chat entities by recency
     * @param chats a list of chat entities
     * @return the list of chat entities sorted by recency of the last text sent
     */
    public ArrayList<Chat> generateSortedChatList(ArrayList<Chat> chats) {
        Collections.sort(chats,
                Comparator.comparing(c-> c.getConversation().get(c.getConversation().size() - 1).getTimeSent()));
        Collections.reverse(chats);
        return chats;
    }

    /**
     * A method that creates a chat between two pets using petIDs
     * @param petID1 ID of the first pet in the chat
     * @param petID2 ID of the second chat in the chat
     */
    public void createChat(String petID1, String petID2) throws IOException {
        Chat newChat = new Chat(generateUniqueChatID());
        CDAI.saveChat(petID1, petID2, newChat);
    }

    /**
     * A method that returns a hashmap of the chats belonging to the pet
     * @param petID the pet id
     * @return a hashmap with chatID as keys and chat entities as values
     */
    public HashMap<String, Chat> getChatsByPet (String petID) {
        HashMap<String, Chat> listOfChats = new HashMap<>();
        for(Chat chat : CDAI.getChatsByPet(petID)){
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
        return CDAI.getChatByID(ChatID);
    }

    public String[][] getTextsList(String chatID) {
        List<Text> conversation = CDAI.getChatByID(chatID).getConversation();
        String[][] textList = new String[conversation.size()][3];
        for(int i = 0; i < conversation.size(); i++){
            textList[i][0] = conversation.get(i).getMessageText();
            textList[i][1] = conversation.get(i).getSenderID();
            textList[i][2] = conversation.get(i).getTimeSent().toString();
        }
        return textList;
    }

    public void sendText(String chatID, String petID, String message) throws IOException {
        Text text = new Text(petID, LocalDateTime.now(), message);
        CDAI.saveText(chatID, text);
    }






}

package controller;

import entities.Chat;
import useCase.Chat.ChatManagerInputBoundary;

import java.io.IOException;
import java.util.ArrayList;

public class ChatController {
    static ChatManagerInputBoundary CMIB;

    public ChatController(ChatManagerInputBoundary CMIB) {
        ChatController.CMIB = CMIB;
    }

    public ArrayList<Chat> getChatsByPet (String petID) {
        ArrayList<Chat> chatList = new ArrayList<>(CMIB.getChatsByPet(petID).values());
        CMIB.generateSortedChatList(chatList);
        return chatList;
    }

    public String[][] getTextsList(String chatID) {
        return CMIB.getTextsList(chatID);
    }

    public void sendText(String chatID, String petID, String message) throws IOException {
        CMIB.sendText(chatID, petID, message);
    }




}

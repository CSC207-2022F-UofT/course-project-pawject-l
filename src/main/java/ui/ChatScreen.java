package ui;

import controller.ChatController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ChatScreen extends JFrame{
    String chatID;
    public ChatScreen(String chatID){
        this.chatID = chatID;
    }

    ArrayList<Container> temporaryMemory = new ArrayList<>();

    public Container createTextBubbles(String[][] listOfTexts, String petID) {
        int i = 20;
        Container container = getContentPane();
        for (int x = 0; x < listOfTexts.length; x++){
            JLabel text;
            Border border;
            int numLines = listOfTexts[x][0].length() / 16;
            if(petID.equals(listOfTexts[x][1])){
                text = new JLabel("<HTML>" + listOfTexts[x][0]+"</HTML>", SwingConstants.RIGHT);
                text.setBounds(230, i, 150, numLines * 20 + 30);
                border = BorderFactory.createLineBorder(Color.RED, 5);
                text.setOpaque(true);
                text.setBackground(Color.PINK);
            }else {
                text = new JLabel("<HTML>" + listOfTexts[x][0] + "</HTML>", SwingConstants.LEFT);
                text.setBounds(3, i, 150, numLines * 20 + 30);
                border = BorderFactory.createLineBorder(Color.GRAY, 5);
                text.setOpaque(true);
                text.setBackground(Color.LIGHT_GRAY);
            }
            i += numLines * 20 + 30;
            text.setBorder(border);
            container.add(text);
        }

        container.setBounds(0,0,400,330);
        container.setBackground(Color.gray);
        container.add(new JPanel());
        return container;
    }

    public void generateChatScreen(ChatController CC, String petID) {
        String[][] listOfTexts = CC.getTextsList(this.chatID);
        JFrame f= new JFrame("Conversation");
        Container container = createTextBubbles(listOfTexts, petID);
        JTextField typeField = new JTextField("");
        typeField.setBounds(0,330, 350,20);
        JButton sendButton = new JButton();
        sendButton.setBounds(355, 330, 25, 20);
        f.add(sendButton);
        f.add(typeField);
        f.setSize(400,400);
        f.add(container);
        f.setLayout(null);
        f.setVisible(true);

        sendButton.addActionListener(evt -> {
            try {
                if(!Objects.equals(typeField.getText(), "")) {
                    CC.sendText(chatID, petID, typeField.getText()); // save text to database
                    typeField.setText("");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });




    }
}

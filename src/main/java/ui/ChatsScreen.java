package ui;

import controller.ChatController;
import entities.Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ChatsScreen extends JFrame {

    /**
     * A method that loads the chats screen ui
     * @param CC chat controller
     * @param petID pet id
     */
    public void loadChatUI(ChatController CC, String petID) {

        JFrame frame = new JFrame("Chat");
        ArrayList<Chat> chatList = CC.getChatsByPet(petID);
        Object[][] DataBase = new Object[chatList.size()][chatList.size()];

        for (int i =0;i<chatList.size();i++) {
            DataBase[i][0] = CC.getOtherPetInChat(petID,chatList.get(i).getChatID());
        }

        String[] headers ={"Chat List"};
        JTable table = new JTable(DataBase,headers);
        table.setDefaultEditor(Object.class, null);
        JScrollPane pane = new JScrollPane(table);
        getContentPane().add(pane,BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.add(pane);
        frame.setVisible(true);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                if (e.getClickCount() == 1) {
                    final JTable jTable = (JTable) e.getSource();
                    final int row = jTable.getSelectedRow();
                    ChatScreen CSU = new ChatScreen(CC.getChatIDByPets(petID, chatList.get(row).getChatID()));
                    CSU.generateChatScreen(CC, petID);
                }
            }
        });


    }

}

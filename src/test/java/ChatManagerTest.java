import entities.Chat;
import entities.Text;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repo.ChatDataAccess;
import repo.ChatDataAccessInterface;
import useCase.ChatManager;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

class ChatManagerTest {
    ChatDataAccessInterface CDAI = new ChatDataAccess();
    ChatManager cm = new ChatManager(CDAI);
    @Test
    public void generatedChatIDIsUnique() {
        String randChatID1 = cm.generateUniqueChatID();
        String randChatID2 = cm.generateUniqueChatID();
        Assertions.assertNotSame(randChatID1, randChatID2);
    }

    @Test
    public void sortedChatListIsSorted(){
        Chat chat1 = new Chat("chatIDTest1");
        Chat chat2 = new Chat("chatIDTest2");
        Chat chat3 = new Chat("chatIDTest3");
        Text text1 = new Text("petID1", LocalDateTime.of(2000,01,01,01,01),"First msg");
        Text text2 = new Text("petID1", LocalDateTime.of(2000,02,01,01,01),"Second msg");
        Text text3 = new Text("petID1", LocalDateTime.of(2000,03,01,01,01),"Third msg");
        Text text4 = new Text("petID1", LocalDateTime.of(2000,04,01,01,01),"Fourth msg");
        chat1.addText(text1);
        chat2.addText(text2);
        chat3.addText(text3);
        chat2.addText(text4);
        ArrayList<Chat> sampleChatList = new ArrayList<>();
        sampleChatList.add(chat1);
        sampleChatList.add(chat2);
        sampleChatList.add(chat3);
        ArrayList<Chat> expected = cm.generateSortedChatList(sampleChatList);
        ArrayList<Chat> actual = new ArrayList<>();
        actual.add(chat2);
        actual.add(chat3);
        actual.add(chat1);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testCreateChat() throws IOException {
        int numChats = cm.getChatsByPet("testPet1").size();
        cm.createChat("testPet1", "testPet2");
        int updatedNumChats = cm.getChatsByPet("testPet1").size();
        System.out.print(updatedNumChats);
        boolean actual = (numChats + 1 == updatedNumChats);
        Assertions.assertTrue(actual);

    }

    @Test
    public void testGetTextsList() throws IOException {
        cm.sendText("testChat", "testPet1", "First Text");
        cm.sendText("testChat", "testPet2", "Second Text");
        String [][] textsList = cm.getTextsList("testChat");
        boolean actual = ((Objects.equals(textsList[textsList.length - 2][0], "First Text")
                && (Objects.equals(textsList[textsList.length - 1][0], "Second Text"))));
        Assertions.assertTrue(actual);
    }

    @Test
    public void testSaveText() throws IOException {
        int numTexts = cm.getTextsList("testChat").length;
        cm.sendText("testChat","testPet1", "Hello there");
        int updatedNumTexts = cm.getTextsList("testChat").length;
        boolean actual = (numTexts + 1 == updatedNumTexts);
        Assertions.assertTrue(actual);
    }
}
package repo;

import entities.Chat;
import entities.Text;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatDataAccess implements ChatDataAccessInterface {

    public ArrayList<Text> getTextsArrayFromString(String texts) {
        ArrayList<Text> textsArray = new ArrayList<>(); // list of text objects
        String[] textsList = texts.split("#"); // List of texts strings
        for(String text : textsList) {
            String[] textInfo = text.split("&");
            // String to datetime
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(textInfo[1], formatter);
            // Create text Object
            Text textObj = new Text(textInfo[0], dateTime, textInfo[2]);
            // Add text object to list of texts
            textsArray.add(textObj);
        }
        return textsArray;
    }


    /**
     * Get all chats from the database by pet
     *
     * @param petID the pet id
     * @return an arraylist of chat entities
     */
    @Override
    public ArrayList<Chat> getChatsByPet(String petID) {
        ArrayList<Chat> chats = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/chatData.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                if((Objects.equals(values[1], petID) || Objects.equals(values[2], petID))){
                    String texts = values[3];

                    ArrayList<Text> textsArray = getTextsArrayFromString(texts);

                    // create a chat object
                    Chat chat = new Chat(values[0]);
                    for(Text text : textsArray) {
                        chat.addText(text);
                    }
                    chats.add(chat);
                }
            }
            br.close();
            return chats;
        } catch (IOException e) {throw new RuntimeException(e);}
    }

    /**
     * Get a chat given the chatID.
     *
     * @param chatID chat ID
     * @return Chat
     */
    @Override
    public Chat getChatByID(String chatID) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/chatData.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if(Objects.equals(values[0], chatID)){
                    String texts = values[3];
                    ArrayList<Text> textsArray = getTextsArrayFromString(texts);

                    // create a chat object
                    Chat chat = new Chat(values[0]);
                    for(Text text : textsArray) {
                        chat.addText(text);
                    }
                    return chat;
                }
            }
            br.close();
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Saves chat in database. Returns true if saved, false if not.
     *
     * @param pet1ID
     * @param pet2ID
     * @param chat
     * @return true if saved, false if not
     */
    @Override
    public boolean saveChat(String pet1ID, String pet2ID, Chat chat) throws IOException {
        try {
            FileWriter writer = new FileWriter("src/chatData.csv", true);
            BufferedWriter bwr = new BufferedWriter(writer);
            LocalDateTime currTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String formattedDateTime = currTime.format(formatter);
            bwr.write(chat.getChatID() + "," + pet1ID + "," + pet2ID + ",system&" +
                    formattedDateTime + "&This is the start of a new Chat. Say hi!#\n");
            bwr.close();
            List<Integer> hi = new ArrayList<>();
            hi.add(3);

            return true;



        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return false;

    }

    public void saveText(String chatID, Text text) throws IOException {
        String sender = text.getSenderID();
        LocalDateTime dtTimeSent = text.getTimeSent();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String timeSent = dtTimeSent.format(dateTimeFormatter);
        String message = text.getMessageText();
        String csvFormattedText = sender + "&" + timeSent + "&" + message + "#";
        Path path = Path.of("src/chatData.csv");
        List<String> fileContent = new ArrayList<>(Files.readAllLines(path, StandardCharsets.UTF_8));

        for (int i = 0; i < fileContent.size(); i++) {
            String line = fileContent.get(i);
            String[] values = line.split(",");
            if(Objects.equals(values[0], chatID)){
                fileContent.set(i, line + csvFormattedText);
            }
        }

        Files.write(path, fileContent, StandardCharsets.UTF_8);
    }

    public String getSecondPetInChat(String chatID, String firstPet) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/chatData.csv"))) {
            String line;
            String pet1 = null;
            String pet2 = null;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if(Objects.equals(chatID, values[0])){
                    pet1 = values[1];
                    pet2 = values[2];
                }
            }
            br.close();
            if(firstPet.equals(pet1)){
                return pet2;
            }
            return pet1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String getChatByPets(String petID1, String petID2) {
        ArrayList<Chat> chats = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/chatData.csv"))) {
            String line;
            String chatID = null;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if(((petID1.equals(values[1]))||(petID1.equals(values[2]))) &&
                        ((petID2.equals(values[1]))||petID2.equals(values[2]))){
                    chatID = values[3];
                }
            }
            br.close();
            return chatID;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

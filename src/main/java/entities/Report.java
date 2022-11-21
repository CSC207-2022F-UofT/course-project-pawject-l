package entities;
import repo.PetDataAccessInterface;
import repo.ChatDataAccessInterface;
import repo.UserDataAccessInterface;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
public class Report implements Serializable {
    /** TypeA (index at 0) punishment is that the suspended account get blocked from logging in.
     *  TypeB (index at 1) contents in the profile get hidden or blocked.
     *  TypeC (index at 2) muted.
     *  TypeD
     *  TypeE
     */
    private int type;
    private User user;
    private Pet pet;
    private Chat chat;

    static int defaultPetID = -1;
    static int defaultChatID = -1;
    static HashMap<String, Integer> types = new HashMap<String, Integer>(){
        {
        types.put("TypeA", 0);
        types.put("TypeB", 1);
        types.put("TypeC", 2);
        }
    };
    public Report(User a, String n, String petId, String chatID, PetDataAccessInterface pm, ChatDataAccessInterface cm){
        this.type = types.get(n);
        this.user = a;
        this.pet = pm.getPetById(petId);
        this.chat = cm.getChatByID(chatID);
    }
    public Report(String userID, String a, UserDataAccessInterface um) throws IOException {
        this.type = types.get(a);
        this.user = um.getUserById(userID);
    }
    public Report(String petID, String b, PetDataAccessInterface pm, UserDataAccessInterface um) throws IOException {
        this.type = types.get(b);
        this.pet = pm.getPetById(petID);
        this.user = um.getUserByPetID(petID);
    }
    public Report(String petID, String chatId, String c, PetDataAccessInterface pm, ChatDataAccessInterface cm){
        this.pet = pm.getPetById(petID);
        this.type = types.get(c);
        this.chat = cm.getChatByID(chatId);
    }

    private void punish(){
        /** Need to work with UI to fully implement this method */
        if (type == 0) {
            user.setPassword("NoNoNo");}
        else if (type == 1) {
           /* pet.setName("NoNoNo");*/
           /* pet.setImage(Image);*/}
        else if (type == 2){
            /*chat.setFlag(false)*/
        }
        return;
    }

    private void checkCounts() {
        if (user.getReportCount()[type] == 3){
            punish();
        };
        return;
        }
    public void report(){
        user.setReportCount(type);
        checkCounts();
        return;
    }
};

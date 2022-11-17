package entities;
import repo.PetDataAccessInterface;
import repo.ChatDataAccessInterface;
import repo.UserDataAccessInterface;
import java.io.Serializable;
import java.util.Objects;
public class Report implements Serializable {
    /** TypeA punishment is that the suspended account get blocked from logging in.
     *  TypeB contents in the profile get hidden or blocked.
     *  TypeC muted.
     *  TypeD
     *  TypeE
     */
    private String type;
    private User user;
    private Pet pet;
    private Chat chat;

    static int defaultPetID = -1;
    static int defaultChatID = -1;

    public Report(User a, String b, String petId, String chatID, PetDataAccessInterface pm){
        this.type = b;
        this.user = a;
        this.pet = pm.getPetById(petId);
        /*this.chat = pet.getChats().get(chatID);*/
    }
    public Report(String userID, String a, UserDataAccessInterface um){
        this.type = a;
        this.user = um.getUserById(userID);
    }
    public Report(String petID, String b, PetDataAccessInterface pm, UserDataAccessInterface um){
        this.type = b;
        this.pet = pm.getPetById(petID);
        this.user = um.getUserByPet(petID);
    }
    public Report(String petID, String chatId, String a, PetDataAccessInterface pm, ChatDataAccessInterface cm){
        this.pet = pm.getPetById(petID);
        this.type = a;
        this.chat = cm.getChatByID(chatId);
    }

    private void punish(){
        /** Need to work with UI to fully implement this method*/
        if (Objects.equals(type, "TypeA")) {
            user.setPassword("NoNoNo");}
        else if (Objects.equals(type, "TypeB")) {
            pet.setName("NoNoNo");
           /* pet.setImage(Image);*/}
        else if (Objects.equals(type, "TypeC")){
            /*chat.setFlag(false)*/
        }
        return;
    }

    private void checkCounts() {
        if (user.getReportCount(type) == 3){
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

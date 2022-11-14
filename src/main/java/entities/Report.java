package entities;
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

    public Report(User a, String b, int petID, int chatID){
        this.type = b;
        this.user = a;
        this.pet = user.getPet(petID);
        /*this.chat = pet.getChats().get(chatID);*/
    }
    public Report(User a, String b, int petID){
        this.type = b;
        this.user = a;
        this.pet = user.getPet(petID);
        /*this.chat = pet.getChats().get(DefaultChatIDd);*/
    }
    public Report(User a, String b){
        this.type = b;
        this.user = a;
        this.pet = user.getPet(defaultPetID);
    }
    public Report(Pet c, String b){
        this.type = b;
        this.pet = c;
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

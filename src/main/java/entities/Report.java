package entities;
import java.lang.reflect.Type;
import java.util.Objects;

public class Report {
    /** Type_A punishment is that the suspended account get blocked from logging in.
     *  Type_B contents in the profile get hidden or blocked.
     *  Type_C muted.
     *  Type_D
     *  Type_E
     */
    private String type;
    private User user;
    private Pet pet;
    private Chat chat;

    static int DefaultPetID = -1;
    static int DefaultChatID = -1;

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
        this.pet = user.getPet(DefaultPetID);
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

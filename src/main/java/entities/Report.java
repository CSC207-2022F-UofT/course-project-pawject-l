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

    static int default_pet_id = -1;
    static int default_chat_id = -1;

    public Report(User a, String b, int pet_id, int chat_id){
        this.type = b;
        this.user = a;
        this.pet = user.getPet(pet_id);
        /*this.chat = pet.getChats().get(chat_id);*/
    }
    public Report(User a, String b, int pet_id){
        this.type = b;
        this.user = a;
        this.pet = user.getPet(pet_id);
        /*this.chat = pet.getChats().get(default_chat_id);*/
    }
    public Report(User a, String b){
        this.type = b;
        this.user = a;
        this.pet = user.getPet(default_pet_id);
    }
    public Report(Pet c, String b){
        this.type = b;
        this.pet = c;
    }

    private void punish(){
        /** Need to work with UI to fully implement this method*/
        if (Objects.equals(type, "Type_A")) {
            user.setPassword("NoNoNo");}
        else if (Objects.equals(type, "Type_B")) {
            pet.setName("NoNoNo");
           /* pet.setImage(Image);*/}
        else if (Objects.equals(type, "Type_C")){
            /*chat.set_flag(false)*/
        }
        return;
    }

    private void check_counts() {
        if (user.getReport_count(type) == 3){
            punish();
        };
        return;
        }
    public void report(){
            if (Objects.equals(type, "Type_A")) {
                user.setReport_count(type);
                check_counts();
            }
            return;
    }
};

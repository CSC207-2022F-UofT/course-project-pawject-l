package entities;
import repo.PetDataAccessInterface;
import repo.ChatDataAccessInterface;
import repo.UserDataAccessInterface;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
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
    private int[] reportCount;
    static int defaultPetID = -1;
    static int defaultChatID = -1;
    static HashMap<String, Integer> types = new HashMap<String, Integer>(){
        {
        types.put("TypeA", 0);
        types.put("TypeB", 1);
        types.put("TypeC", 2);
        }
    };
    public Report(User a, String n, String petId, String chatID, PetDataAccessInterface pm, ChatDataAccessInterface cm) throws IOException {
        this.type = types.get(n);
        this.user = a;
        this.pet = pm.getPetById(petId);
        this.chat = cm.getChatByID(chatID);
        String[] str = user.getReportCount().split("\\$");
        this.reportCount = new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt((str[2]))};
    }
    public Report(String userID, String a, UserDataAccessInterface um) throws IOException {
        this.type = types.get(a);
        this.user = um.getUserById(userID);
        String[] str = user.getReportCount().split("\\$");
        this.reportCount = new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt((str[2]))};
    }
    public Report(String petID, String b, PetDataAccessInterface pm, UserDataAccessInterface um) throws IOException {
        this.type = types.get(b);
        this.pet = pm.getPetById(petID);
        this.user = um.getUserByPetID(petID);
        String[] str = user.getReportCount().split("\\$");
        this.reportCount = new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt((str[2]))};
    }
    public Report(String petID, String chatId, String c, PetDataAccessInterface pm, ChatDataAccessInterface cm) throws IOException {
        this.pet = pm.getPetById(petID);
        this.type = types.get(c);
        this.chat = cm.getChatByID(chatId);
        String[] str = user.getReportCount().split("\\$");
        this.reportCount = new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt((str[2]))};
    }

    private void punish() throws IOException {
        /** Need to work with UI to fully implement this method */
//        if (type == 0) {
//            The user is blocked from logging in.
//        else if (type == 1) {
//            The image of the pet got hidden
//        else if (type == 2){
//            The user got muted.
//        };
        return;
    }

    private void checkCounts() throws IOException {
        if (this.reportCount[type] == 3){
            punish();
        };
        return;
        }
    public void report() throws IOException {
        reportCount[type] += 1;
        String str = reportCount[0] + "$" + reportCount[1] + "$" + reportCount[2];
        user.setReportCount(str);
        checkCounts();
        return;
    }
};

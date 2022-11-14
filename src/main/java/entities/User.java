package entities;
import java.util.HashMap;
import java.util.List;
public class User {

    public int userID;
    public String username;
    public String password;
    private List<Pet> pets;
    private int reportCount;
    private HashMap<String, Integer> report_count;

    // constructor that doesn't take in pet
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(int user_id, String password, String username, int report_count) {
        this.userID = user_id;
        this.password = password;
        this.username = username;
        this.reportCount = 0;
    }
    public User(Pet pet){
        this.pets.add(pet);
        this.report_count = new HashMap<String, Integer>();
        this.report_count.put("Type_A", 0);
        this.report_count.put("Type_B", 0);
        this.report_count.put("Type_C", 0);
    }

    public int getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
    public int getReportCount() {
        return reportCount;
    }
    public int getReport_count(String key) {
        return report_count.get(key);
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setName(String name) {
        this.username = name;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void setReportCount(int reportCount) {
        this.reportCount = reportCount;
    }
    public void setReport_count(String key) {
        this.report_count.put(key, report_count.get(key)+1);
    }
}


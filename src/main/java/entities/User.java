package entities;
import java.util.HashMap;
import java.util.List;
public class User {

    public String userID;
    public String username;
    public String password;
    private List<Pet> pets;
    private int reportCount;
    private HashMap<String, Integer> report_count;
    private HashMap<String, Integer> reportCount;

    // constructor that doesn't take in pet
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(String user_id, String password, String username, int report_count) {
        this.userID = user_id;
        this.password = password;
        this.username = username;
        this.reportCount = 0;
    }
    public User(Pet pet){
        this.pets.add(pet);
        this.reportCount = new HashMap<String, Integer>();
    }

    public String getUserID() {
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

    public int getReportCount(String key) {
        return reportCount.get(key);
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setName(String name) {
        this.username = name;
    }

    public void setUserID(String userID) {
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
    public void setReportCount(String key) {
        if (this.reportCount.containsKey(key)) {
            this.reportCount.put(key, reportCount.get(key) + 1);
        }
        else {this.reportCount.put(key, 1);}
    }
}


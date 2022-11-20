package entities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class User {

    public String userID;
    public String username;
    public String password;
    private List<Pet> pets;
    private int[] reportCount;

    public User(String user_id, String password, String username) {
        this.userID = user_id;
        this.password = password;
        this.username = username;
        this.reportCount = new int[]{0, 0, 0};
    }
    public User(Pet pet){
        this.pets.add(pet);
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

    public int[] getReportCount() {
        return reportCount;
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

    public void setReportCount(int index) {
        this.reportCount[index] += 1;
    }
}


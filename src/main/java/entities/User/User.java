package entities.User;
import entities.Pet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// entity layer
public class User {

    private String userID;
    private String username;
    private String password;
    private List<Pet> pets;
    private HashMap<String, Integer> reportCount;

    /**
     * Creates a new User with the given userID, username, and password.
     *
     * @param username A String containing the User's username.
     * @param password A String containing the User's password.
     */
    public User(String username, String password) {
        this.userID = idGenerator();
        this.password = password;
        this.username = username;
        this.pets = new ArrayList<Pet>();
        this.reportCount = new HashMap<String, Integer>();
    }

    public static String idGenerator() {
        String alphaNumString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz" + "123456789";
        StringBuilder sb = new StringBuilder(8);

        for (int i = 0; i < 8; i++) {
            int index = (int)(alphaNumString.length() * Math.random());
            sb.append(alphaNumString.charAt(index));
        }
        return sb.toString();
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

    public void setReportCount(String key) {
        if (this.reportCount.containsKey(key)) {
            this.reportCount.put(key, reportCount.get(key) + 1);
        }
        else {this.reportCount.put(key, 1);}
    }
}


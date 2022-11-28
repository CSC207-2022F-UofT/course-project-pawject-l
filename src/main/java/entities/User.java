package entities;
import repo.PetDataAccessInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class User {

    public String userID;
    public String username;
    public String password;
    private List<String> pets;
    private int[] reportCount;

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
    }

    /**
     * Generates a unique userID composed of 8 alphanumeric characters.
     *
     * @return a randomly generated string userID.
     */
    public static String idGenerator() {
        String alphaNumString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz" + "123456789";
        StringBuilder sb = new StringBuilder(8);

        for (int i = 0; i < 8; i++) {
            int index = (int)(alphaNumString.length() * Math.random());
            sb.append(alphaNumString.charAt(index));
        }
        return sb.toString();
    }

    public User(String user_id, String username, String password, String petID, String reportCount) {
        this.userID = user_id;
        this.password = password;
        this.username = username;
        this.pets = new ArrayList<String>();
        this.pets.addAll(Arrays.asList(petID.split("\\$")));
        String[] a = reportCount.split("\\$");
        this.reportCount = new int[]{Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt((a[2]))};
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

    public List<Pet> getPets(PetDataAccessInterface pi) throws IOException {
        List<Pet> petList = new ArrayList<Pet>();
        for (String pet: this.pets){
            petList.add(pi.getPetById(pet));
        }
        return petList;
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

    public void setPets(List<String> petIDs) {
        this.pets = petIDs;
    };
    public void setReportCount(int index) {
        this.reportCount[index] += 1;
    }
}


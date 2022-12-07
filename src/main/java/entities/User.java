package entities;

import repo.UserDataAccessInterface;

import java.io.IOException;

public class User {

    private String userID;
    private String username;
    private String password;

    // changed from list to string
    private String petID;
    private String reportCount;
    static UserDataAccessInterface um;


    /**
     * Creates a new User with the given userID, username, and password.
     *
     * @param username A String containing the User's username.
     * @param password A String containing the User's password.
     */
    public User(String username, String password) throws IOException {
        this.userID = idGenerator();
        this.password = password;
        this.username = username;
        this.petID = petIDGenerator();
        this.reportCount = "0$0$0";
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
    private String petIDGenerator() throws IOException {
        String id = "PetID: " + (um.CountUser() + 1);
        return id;
    };
    public User(String user_id, String username, String password, String petID, String reportCount) {
        this.userID = user_id;
        this.password = password;
        this.username = username;
        this.petID = petID;
        this.reportCount = reportCount;
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

    public String getReportCount() {
        return reportCount;
    }

    public String getPet() {return petID;}

    public void setName(String name) throws IOException {
        this.username = name;
        um.saveUser(userID, name, password, petID, reportCount);
    }

    public void setUserID(String userID) throws IOException {
        this.userID = userID;
        um.saveUser(userID, username, password, petID, reportCount);
    }

    public void setPassword(String password) throws IOException {
        this.password = password;
        um.saveUser(userID, username, password, petID, reportCount);
    }

    public void setPets(String petID) throws IOException {
        this.petID = petID;
        um.saveUser(userID, username, password, petID, reportCount);
    };
    public void setReportCount(String str) throws IOException {
        this.reportCount = str;
        um.saveUser(userID, username, password, petID, str);
    }
}

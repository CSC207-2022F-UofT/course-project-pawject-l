package useCase;

import java.util.HashMap;


public class AccountModel {
    public int userID;
    public String username;
    public String password;
    public static HashMap<Integer, String> idUserDict = new HashMap<>();
    public static HashMap<String, String> userPassDict = new HashMap<>();


    public AccountModel(String username, String password) {
        this.userID = 0;
        this.username = username;
        this.password = password;
    }

    /**
     * Checks if the password is valid. A password is valid if it has at least 6 characters, has at least one lowercase
     * and one uppercase character, has at least one number, and has no spaces.
     *
     * @return true if the password is valid, false otherwise.
     */
    public static boolean checkPasswordValid(String password) {
        if (password.length() < 6) {
            return false;
        } else {
            boolean checkLowerCase = false;
            boolean checkUpperCase = false;
            boolean checkNumber = false;
            for (char c : password.toCharArray()) {
                if (c == ' ') {
                    return false;
                } else if (Character.isLowerCase(c)) {
                    checkLowerCase = true;
                } else if (Character.isUpperCase(c)) {
                    checkUpperCase = true;
                } else if (Character.isDigit(c)) {
                    checkNumber = true;
                }
            }
            return checkLowerCase == checkUpperCase && checkUpperCase == checkNumber && checkLowerCase == checkNumber;
        }
    }

    /**
     * Creates a user by appending the username and password into userDict.
     */
    public void createUser() {
        userID = idUserDict.size() + 1;
        idUserDict.put(userID, username);
        userPassDict.put(username, password);
    }

    /**
     * Checks if the username is already in userPassDict.
     *
     * @param username username to be checked
     * @return true if the username is already in userDict, false otherwise.
     */
    public static boolean userExists(String username) {
        if (userPassDict.containsKey(username)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if the given password matches the user's password.
     *
     * @param password the inputted password
     * @return true if the given password matches the user's password, false otherwise.
     */
    public boolean correctPassword(String password) {
        if (userPassDict.get(username) == password) {
            return true;
        }
        return false;
    }
}

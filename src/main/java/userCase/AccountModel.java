package userCase;

import entities.Pet;
import entities.User;

public class AccountModel extends User {

    public AccountModel(int user_id, String password, String username, Pet pet) {
        super(user_id, password, username, pet);
    }

    /**
     * Checks if the password is valid. A password is valid if it has at least 6 characters, has at least one lowercase
     * and one uppercase character, has at least one number, has at least one special character, and has no spaces.
     * @return true if the password is valid, false otherwise.
     */
    public boolean checkPasswordValid() {
        if (password.length() < 6) {
            return false;
        } else {
            char ch;
            boolean checkLowerCase = false;
            boolean checkUpperCase = false;
            boolean checkNumber = false;
            boolean checkSpecChar = false;
            for (int i = 0; i < password.length(); i++) {
                ch = password.charAt(i);
                if (Character.isSpace(ch)) {
                    return false;
                } else if (Character.isLowerCase(ch)) {
                    checkLowerCase = true;
                } else if (Character.isUpperCase(ch)) {
                    checkUpperCase = true;
                } else if (Character.isDigit(ch)) {
                    checkNumber = true;
                } else if (!Character.isLetter(ch) && !Character.isDigit(ch) && !Character.isSpace(ch)) {
                    checkSpecChar = true;
                }
            } return checkLowerCase == checkUpperCase == checkNumber == checkSpecChar;
        }
    }

    public boolean userExists() {
        return true;
    }
}

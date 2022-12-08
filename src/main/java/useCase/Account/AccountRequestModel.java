package useCase.Account;

import entities.User;

import java.io.IOException;

// use case layer

public class AccountRequestModel {
    private String username;
    private String password;
    private String petId;


    public AccountRequestModel(String username, String password, String petId) {
        this.username = username;
        this.password = password;
        this.petId = petId;
    }

    public String getPetId() {
        return petId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    void setUsername(String username) {
        this.username = username;
    }

    void setPassword(String password) {
        this.password = password;
    }

    public boolean checkPasswordValid() {
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
}

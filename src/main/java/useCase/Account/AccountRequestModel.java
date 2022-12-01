package useCase.Account;

import entities.User;

import java.io.IOException;

// use case layer

public class AccountRequestModel {
    private String username;
    private String password;


    public AccountRequestModel(String username, String password) {
        this.username = username;
        this.password = password;
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
}

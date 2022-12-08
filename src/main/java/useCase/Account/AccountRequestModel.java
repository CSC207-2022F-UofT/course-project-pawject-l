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
    }

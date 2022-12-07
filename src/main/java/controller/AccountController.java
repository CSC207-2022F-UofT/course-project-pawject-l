package controller;

import entities.User;
import repo.UserDataAccess;
import useCase.Account.AccountInputBoundary;
import useCase.Account.AccountRequestModel;
import repo.UserDataAccessInterface;

import java.io.IOException;

public class AccountController{
    final AccountInputBoundary userInput;

    public AccountController(AccountInputBoundary userInput) {
        this.userInput = userInput;
    }

    public boolean userExists(String username, String password, String petId) throws IOException {
        AccountRequestModel requestModel = new AccountRequestModel(username, password, petId);
        return userInput.userExists(requestModel);
    }

    public boolean checkPasswordValid(String username, String password, String petId){
        AccountRequestModel requestModel = new AccountRequestModel(username, password, petId);
        return userInput.checkPasswordValid(requestModel);
    }

    public boolean correctPassword(String username, String password, String petId) throws IOException {
        AccountRequestModel requestModel = new AccountRequestModel(username, password, petId);
        return userInput.correctPassword(requestModel);
    }

    public void create(String username, String password, String petId) throws IOException {
        AccountRequestModel requestModel = new AccountRequestModel(username, password, petId);
        userInput.create(requestModel);
    }
}
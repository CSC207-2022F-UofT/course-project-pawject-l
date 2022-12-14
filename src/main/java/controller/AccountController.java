package controller;

import entities.User;
import repo.UserDataAccess;
import useCase.Account.AccountInputBoundary;
import useCase.Account.AccountRequestModel;
import repo.UserDataAccessInterface;
import useCase.Account.AccountRequestModel1;

import java.io.IOException;

public class AccountController{
    final AccountInputBoundary userInput;

    public AccountController(AccountInputBoundary userInput) {
        this.userInput = userInput;
    }

    public boolean userExists(String username, String password) throws IOException {
        AccountRequestModel1 requestModel = new AccountRequestModel1(username, password);
        return userInput.userExists(requestModel);
    }

    public boolean checkPasswordValid(String username, String password){
        AccountRequestModel1 requestModel = new AccountRequestModel1(username, password);
        return userInput.checkPasswordValid(requestModel);
    }

    public boolean correctPassword(String username, String password) throws IOException {
        AccountRequestModel1 requestModel = new AccountRequestModel1(username, password);
        return userInput.correctPassword(requestModel);
    }

    public void create(String username, String password, String petId) throws IOException {
        AccountRequestModel requestModel = new AccountRequestModel(username, password, petId);
        userInput.create(requestModel);
    }
}
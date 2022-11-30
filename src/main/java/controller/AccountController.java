/**package controller;

import userCase.Account.AccountInputBoundary;

public class AccountController{
    final AccountInputBoundary inputBoundary;

    public AccountController(AccountInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public boolean logIn(String username, String password) {
        if (inputBoundary.userExists(username)) {
            if (inputBoundary.correctPassword(username, password)) {
                return true;
            }
        } return false;
    }

    public void signUp(String username, String password) {
        if (!inputBoundary.userExists(username)) {
            if (inputBoundary.checkPasswordValid(password)) {
                inputBoundary.createUser();
            }
        }
    }
}
*/
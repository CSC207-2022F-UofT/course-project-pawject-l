package controller;

import entities.User;
import useCase.Account.AccountInputBoundary;
import java.util.HashMap;

public class AccountController{
    final AccountInputBoundary userInput;

    //    Have to change when database is done
    public static HashMap<String, String> idUserDict = new HashMap<>();
    public static HashMap<String, String> userPassDict = new HashMap<>();

    public AccountController(AccountInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    public static boolean checkPasswordValid(String username, String password) {
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

    public static boolean userExists(String username, String password) {
        if (userPassDict.containsKey(username)) {
            return true;
        } else {
            return false;
        }
    }

    public static void createUser(String username, String password) {
        User user = new User(username, password);
        idUserDict.put(user.getUserID(), user.getUsername());
        userPassDict.put(user.getUsername(), user.getPassword());
    }

    public static boolean correctPassword(String username, String password) {
        if (userPassDict.get(username) == password) {
            return true;
        }
        return false;
    }
//    public static boolean signUp(String username, String password) {
//        if (!inputBoundary.userExists(username)) {
//            if (inputBoundary.checkPasswordValid(password)) {
//                inputBoundary.createUser(username, password);
//                return true;
//            }
//        } return false;
//    }
//    public boolean logIn(String username, String password) {
//        if (inputBoundary.userExists(username)) {
//            if (inputBoundary.correctPassword(username, password)) {
//                return true;
//            }
//        } return false;
//    }
}
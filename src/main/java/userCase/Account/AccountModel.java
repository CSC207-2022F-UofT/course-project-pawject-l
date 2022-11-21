package userCase.Account;

import entities.User;
import repo.UserDataRequestModel;

import java.util.HashMap;

// use case layer

public class AccountModel {
    UserDataRequestModel accountDsGateway;
    public static HashMap<String, String> idUserDict = new HashMap<>();
    public static HashMap<String, String> userPassDict = new HashMap<>();


    public AccountModel(UserDataRequestModel accountDsGateway) {
        this.accountDsGateway = accountDsGateway;
    }

//    public static void main(String[] args) {
//        AccountModel user = new AccountModel("User", "HelloWorld1");
//        user.createUser();
//        AccountModel user1 = new AccountModel("elyse", "HelloWorld1");
//        user1.createUser();
//        System.out.println(idUserDict);
//    }

    /**
     * Checks if the password is valid. A password is valid if it has at least 6 characters, has at least one lowercase
     * and one uppercase character, has at least one number, and has no spaces.
     *
     * @return true if the password is valid, false otherwise.
     */
    public boolean checkPasswordValid(AccountRequestModel requestModel) {
        User user = accountDsGateway.getUserByUsername(requestModel.getUsername());
        String password = user.getPassword();
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
     *
     * @return
     */
    public AccountResponseModel createUser(AccountRequestModel requestModel) {
        User user = accountDsGateway.getUserByUsername(requestModel.getUsername());
        idUserDict.put(user.getUserID(), user.getUsername());
        userPassDict.put(user.getUsername(), user.getPassword());
        AccountResponseModel responseModel = new AccountResponseModel(user.getUsername());
        return responseModel;
    }

    /**
     * Checks if the username is already in userPassDict.
     * <p>
     * //     * @param username username to be checked
     *
     * @return true if the username is already in userDict, false otherwise.
     */
    public boolean userExists(AccountRequestModel requestModel) {
        User user = accountDsGateway.getUserByUsername(requestModel.getUsername());
        if (userPassDict.containsKey(requestModel.getUsername())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if the given password matches the user's password.
     * <p>
     * //     * @param password the inputted password
     *
     * @return true if the given password matches the user's password, false otherwise.
     */
    public boolean correctPassword(AccountRequestModel requestModel, String password) {
        User user = accountDsGateway.getUserByUsername(requestModel.getUsername());
        if (userPassDict.get(user.getUsername()) == password) {
            return true;
        }
        return false;
    }
}
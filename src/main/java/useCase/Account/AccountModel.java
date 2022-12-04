package useCase.Account;

import entities.User;
import repo.UserDataAccessInterface;

import java.io.IOException;
import java.util.Objects;

// use case layer

public class AccountModel implements AccountInputBoundary{
    UserDataAccessInterface accountDsGateway;

    public AccountModel(UserDataAccessInterface accountDsGateway) {
        this.accountDsGateway = accountDsGateway;
    }

    /**
     * Checks if the password is valid. A password is valid if it has at least 6 characters, has at least one lowercase
     * and one uppercase character, has at least one number, and has no spaces.
     *
     * @return true if the password is valid, false otherwise.
     */
    public boolean checkPasswordValid(AccountRequestModel requestModel) {
        String password = requestModel.getPassword();
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
     * Checks if the given password matches the user's password.
     * <p>
     * //     * @param password the inputted password
     *
     * @return true if the given password matches the user's password, false otherwise.
     */
    public boolean correctPassword(String username, String password) throws IOException {
        User user = accountDsGateway.getUser(username);
        return Objects.equals(user.getPassword(), password);
    }

    public boolean userExists(AccountRequestModel requestModel) throws IOException {
        if (accountDsGateway.existsUser(requestModel.getUsername()) == true) {
            return true;
        } else {
            return false;
        }
    }

    public void create(AccountRequestModel requestModel) throws IOException {
        User user = new User(requestModel.getUsername(), requestModel.getPassword());
        accountDsGateway.save(user);
    }
}

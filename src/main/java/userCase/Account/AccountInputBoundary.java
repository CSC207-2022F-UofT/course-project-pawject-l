package userCase.Account;

public interface AccountInputBoundary {
    AccountResponseModel createUser(AccountRequestModel requestModel);

    boolean checkPasswordValid(String password);

    void createUser();

    boolean userExists(String username);

    boolean correctPassword(String username, String password);

}

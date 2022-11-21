package useCase.Account;

public interface AccountInputBoundary {
    public boolean checkPasswordValid(AccountRequestModel requestModel);
    public AccountResponseModel createUser(AccountRequestModel requestModel);
    public boolean userExists(AccountRequestModel requestModel);
    public boolean correctPassword(AccountRequestModel requestModel, String password);

}

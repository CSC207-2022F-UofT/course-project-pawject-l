package useCase.Account;

import java.io.IOException;

public interface AccountInputBoundary {
    public boolean checkPasswordValid(AccountRequestModel requestModel);
    public void create(AccountRequestModel requestModel) throws IOException;
    public boolean userExists(AccountRequestModel requestModel) throws IOException;
    public boolean correctPassword(String username, String password) throws IOException;

}

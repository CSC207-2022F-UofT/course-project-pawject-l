package useCase.Account;

import java.io.IOException;

public interface AccountInputBoundary {
    public boolean checkPasswordValid(AccountRequestModel1 requestModel);
    public void create(AccountRequestModel requestModel) throws IOException;
    public boolean userExists(AccountRequestModel1 requestModel) throws IOException;
    public boolean correctPassword(AccountRequestModel1 requestModel) throws IOException;

}

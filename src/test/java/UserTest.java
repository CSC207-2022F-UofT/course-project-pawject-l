import controller.AccountController;
import entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repo.UserDataAccess;
import repo.UserDataAccessInterface;
import useCase.Account.AccountInputBoundary;
import useCase.Account.AccountModel;

import java.io.IOException;

public class UserTest {
    UserDataAccessInterface userDS = new UserDataAccess();
    AccountInputBoundary acc = new AccountModel(userDS);
    AccountController accCtrl = new AccountController(acc);

    @Test
    public void UserCreationTest() throws IOException {
        String username = "User1";
        String password = "User123";
        User user = new User(username, password);
        user.setPets("PET ID:0");

        //username.equals(value.get(i)) fixed

        userDS.saveUser(user.getUserID(), user.getUsername(), user.getPassword(), user.getPet(), "0\\$0\\$0\\$");
        User userrr = userDS.getUserByUsername(username);

        Assertions.assertEquals(userrr.getUsername(), username);
        Assertions.assertEquals(userrr.getPassword(), password);
        Assertions.assertEquals(userrr.getPet(), user.getPet());
        Assertions.assertEquals(userrr.getUserID(), user.getUserID());
    }
}
    
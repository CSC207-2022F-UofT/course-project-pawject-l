import controller.AccountController;
import entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repo.UserDataAccess;
import repo.UserDataAccessInterface;
import useCase.Account.AccountInputBoundary;
import useCase.Account.AccountModel;
import useCase.Account.AccountRequestModel1;

import java.io.IOException;

public class UserTest {
    UserDataAccessInterface userDS = new UserDataAccess();
    AccountInputBoundary acc = new AccountModel(userDS);
    AccountController accCtrl = new AccountController(acc);

    // Have to ensure each user created is not in userData before running tests.

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

    @Test
    public void checkPasswordValidFailsTest() {
        String username = "User";
        String password = "user";
        AccountRequestModel1 reqMod = new AccountRequestModel1(username, password);
        Assertions.assertFalse(acc.checkPasswordValid(reqMod));
    }
    @Test
    public void checkPasswordValidWorksTest() {
        String username = "User";
        String password = "User123";
        AccountRequestModel1 reqMod = new AccountRequestModel1(username, password);
        Assertions.assertTrue(acc.checkPasswordValid(reqMod));
    }

    @Test
    public void CorrectPasswordFailsTest() throws IOException {
        String username = "User2";
        String password = "User123";
        User user = new User(username, password);
        user.setPets("PET ID:0");

        userDS.saveUser(user.getUserID(), user.getUsername(), user.getPassword(), user.getPet(), "0\\$0\\$0\\$");

        String username1 = "User2";
        String password1 = "user";
        AccountRequestModel1 reqMod = new AccountRequestModel1(username1, password1);
        Assertions.assertFalse(acc.correctPassword(reqMod));
    }

    @Test
    public void CorrectPasswordWorksTest() throws IOException {
        String username = "User3";
        String password = "User123";
        User user = new User(username, password);
        user.setPets("PET ID:0");

        userDS.saveUser(user.getUserID(), user.getUsername(), user.getPassword(), user.getPet(), "0\\$0\\$0\\$");

        String username1 = "User3";
        String password1 = "User123";
        AccountRequestModel1 reqMod = new AccountRequestModel1(username1, password1);
        Assertions.assertTrue(acc.correctPassword(reqMod));
    }

    @Test
    public void UserExistsFailsTest() throws IOException {
        String username = "User4";
        String password = "User123";
        User user = new User(username, password);
        user.setPets("PET ID:0");

        userDS.saveUser(user.getUserID(), user.getUsername(), user.getPassword(), user.getPet(), "0\\$0\\$0\\$");

        String username1 = "user";
        String password1 = "User123";
        AccountRequestModel1 reqMod = new AccountRequestModel1(username1, password1);
        Assertions.assertFalse(acc.userExists(reqMod));
    }

    @Test
    public void UserExistsWorksTest() throws IOException {
        String username = "User5";
        String password = "User123";
        User user = new User(username, password);
        user.setPets("PET ID:0");

        userDS.saveUser(user.getUserID(), user.getUsername(), user.getPassword(), user.getPet(), "0\\$0\\$0\\$");

        String username1 = "User5";
        String password1 = "User123";
        AccountRequestModel1 reqMod = new AccountRequestModel1(username1, password1);
        Assertions.assertTrue(acc.userExists(reqMod));
    }
}
    
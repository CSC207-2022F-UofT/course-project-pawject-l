package user;

import userCase.AccountModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;




public class UserTest {

    @Test
    public void passwordWorks() {
        AccountModel user = new AccountModel("elyse", "Javabae1!");
        Assertions.assertEquals(true, AccountModel.checkPasswordValid(user.password));
    }

    @Test
    public void passwordFails() {
        AccountModel user = new AccountModel("elyse", "111111111");
        Assertions.assertEquals(false, AccountModel.checkPasswordValid(user.password));
    }

    @Test
    public void createUserTest1() {
        AccountModel user = new AccountModel("elyse", "Javabae1!");
        user.createUser();
        Assertions.assertEquals(true, AccountModel.userPassDict.containsKey("elyse"));
    }

    @Test
    public void userExistsTest() {
        AccountModel user1 = new AccountModel("user1", "Javabae1!");
        user1.createUser();
        Assertions.assertEquals(true, AccountModel.userExists(user1.username));
    }

    @Test
    public void correctPasswordWorks() {
        AccountModel user1 = new AccountModel("user1", "Javabae1!");
        user1.createUser();
        Assertions.assertEquals(true, user1.correctPassword("Javabae1!"));
    }
    @Test
    public void correctPasswordFails() {
        AccountModel user1 = new AccountModel("user1", "Javabae1!");
        user1.createUser();
        Assertions.assertEquals(false, user1.correctPassword("Javabae1"));
    }



}

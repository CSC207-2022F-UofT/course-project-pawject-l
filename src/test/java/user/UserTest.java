//package user;
//
//import userCase.Account.AccountModel;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//
//public class UserTest {
//
//    @Test
//    public void passwordWorks() {
//        AccountModel user = new AccountModel("User", "HelloWorld1");
//        assertTrue(AccountModel.checkPasswordValid(user.getPassword()));
//    }
//
//    @Test
//    public void passwordFails() {
//        AccountModel user = new AccountModel("User", "111111111");
//        assertFalse(AccountModel.checkPasswordValid(user.getPassword()));
//    }
//
//    @Test
//    public void createUserTest1() {
//        AccountModel user = new AccountModel("User", "HelloWorld1");
//        user.createUser();
//        assertTrue(AccountModel.userPassDict.containsKey(user.getUsername()));
//    }
//
//    @Test
//    public void userExistsTest() {
//        AccountModel user = new AccountModel("User", "HelloWorld1");
//        user.createUser();
//        assertTrue(AccountModel.userExists(user.getUsername()));
//    }
//
//    @Test
//    public void correctPasswordWorks() {
//        AccountModel user = new AccountModel("User", "HelloWorld1");
//        user.createUser();
//        assertTrue(user.correctPassword(user.getPassword()));
//    }
//
//    @Test
//    public void correctPasswordFails() {
//        AccountModel user = new AccountModel("User", "HelloWorld1");
//        user.createUser();
//        assertFalse(user.correctPassword("test"));
//    }
//}

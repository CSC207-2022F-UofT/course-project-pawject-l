package data;

import repo.ChatDataAccessInterface;
import repo.PetDataAccessInterface;
import repo.UserDataAccess;
import repo.UserDataAccessInterface;

import java.io.IOException;

public class UserTest {
    private static PetDataAccessInterface pm;
    private static ChatDataAccessInterface cm;
    private static UserDataAccessInterface um;
    public UserTest(PetDataAccessInterface pm, ChatDataAccessInterface cm, UserDataAccessInterface um){
        UserTest.pm = pm;
        UserTest.cm = cm;
        UserTest.um = um;
    }
    public static void main(String[] args) throws IOException {
        System.out.print(um.getUserById("12345678").getUserID());
    }
}

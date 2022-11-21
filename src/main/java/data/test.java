package data;

import repo.ChatDataAccessInterface;
import repo.PetDataAccessInterface;
import repo.UserDataAccess;
import repo.UserDataAccessInterface;

import java.io.IOException;

public class test {
    private static PetDataAccessInterface pm;
    private static ChatDataAccessInterface cm;
    private static UserDataAccessInterface um;
    public test(PetDataAccessInterface pm, ChatDataAccessInterface cm, UserDataAccessInterface um){
        test.pm = pm;
        test.cm = cm;
        test.um = um;
    }
    public static void main(String[] args) throws IOException {
        System.out.print(um.existsUsername("12345678"));
        System.out.print("123");
    }
}

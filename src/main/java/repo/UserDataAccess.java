package repo;
import repo.*;
import entities.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserDataAccess implements UserDataAccessInterface{
    /**
     * "0001","student","password",["0001","0002"],[0,0,0]
     */
    @Override
    public User getUserById(String id) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public boolean saveUser(User user) {
        return false;
    }

    @Override
    public boolean existsUsername(String username) {
        return false;
    }

    @Override
    public User getUserByPetID(String petID) {
        return null;
    }

    @Override
    public void deleteUser(String username) {

    }


}


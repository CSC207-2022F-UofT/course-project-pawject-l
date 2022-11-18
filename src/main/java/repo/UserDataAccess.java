package repo;
import repo.*;
import entities.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class UserDataAccess implements UserDataAccessInterface{
    /**
     * "0001","student","password","0001"$"0002",0$0$0
     * 0,         1,         2,       3,           4
     */
    @Override
    public User getUserById(String id) throws IOException {
        FileReader fr = new FileReader("123.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        ArrayList<String> value = null;
        while((line = br.readLine()) != null){
            value.add(Arrays.toString(line.split(",")));
        }
        br.close();
        fr.close();
        int i = 0;
        while (i < value.size()){
            if (Objects.equals(value.get(i), id)){
                return new User(id, value.get(i + 1), value.get(i + 2));
            }
            i += 5;
        }
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


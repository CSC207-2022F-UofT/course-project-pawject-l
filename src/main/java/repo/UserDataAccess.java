package repo;
import entities.User;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class UserDataAccess implements UserDataAccessInterface{
    /**
     * userID, username, password, petIDs,  reportCounts
     * "0000001","student","password","PET ID:0001$PET ID:0002","0$0$0"
     * 0,         1,         2,       3,           4
     */
    static String defaultUserID = "00000001";
    static String defaultPetID = "00000001";
    static String defaultReportCount = "0$0$0";
    static String filename = "userData";
    @Override
    public User getUserById(String id) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        ArrayList<String> value = null;
        while((line = br.readLine()) != null){
            value.addAll(Arrays.asList(line.split(",")));
        }
        br.close();
        fr.close();
        int i = 0;
        while (i + 5 <= value.size()){
            if (Objects.equals(value.get(i), id)){
                return new User(id, value.get(i + 1), value.get(i + 2), value.get(i+3), value.get(i+4));
            }
            i += 5;
        }
        return null;
    }

    @Override
    public User getUserByUsername(String username) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        ArrayList<String> value = null;
        while((line = br.readLine()) != null){
            value.addAll(Arrays.asList(line.split(",")));
        }
        br.close();
        fr.close();
        int i = 1;
        while (i + 4 <= value.size()){
            if (Objects.equals(value.get(i), username)){
                return new User(value.get(i - 1), username, value.get(i + 2), value.get(i+3), value.get(i+4));
            }
            i += 5;
        }
        return null;
    }

    @Override
    public boolean saveUser(String username, String password) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        ArrayList<String> value = null;
        while((line = br.readLine()) != null){
            value.addAll(Arrays.asList(line.split(",")));
        }
        br.close();
        fr.close();
        int i = 1;
        boolean flag = false;
        while (i + 4 <= value.size() && !flag) {
            if (Objects.equals(value.get(i), username)) {
                value.add(defaultUserID);
                value.add(username);
                value.add(password);
                value.add(defaultPetID);
                value.add(defaultReportCount);
                flag = true;
            }
            i += 5;
        }
        if (flag) {
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(value.toString());
            br.close();
            fr.close();
        }
        return flag;
    }

    @Override
    public boolean existsUsername(String username) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        ArrayList<String> value = null;
        while((line = br.readLine()) != null){
            value.addAll(Arrays.asList(line.split(",")));
        }
        br.close();
        fr.close();
        return value!= null && value.contains(username);
    }

    @Override
    public User getUserByPetID(String petID) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        ArrayList<String> value = null;
        while((line = br.readLine()) != null){
            value.addAll(Arrays.asList(line.split(",")));
        }
        br.close();
        fr.close();
        int i = 3;
        while (i + 2 <= value.size()){
            if (Arrays.asList(value.get(i).split("$")).contains(petID)){
                return new User(value.get(i-3), value.get(i-2), value.get(i-1), value.get(i), value.get(i+1));
            }
            i += 5;
        }
        return null;
    }

    @Override
    public boolean deleteUser(String username) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        ArrayList<String> value = null;
        while((line = br.readLine()) != null){
            value.addAll(Arrays.asList(line.split(",")));
        }
        br.close();
        fr.close();
        int i = 1;
        boolean flag = false;
        while (i + 4 <= value.size() && !flag) {
            if (Objects.equals(value.get(i), username)) {
                value.subList(i - 1, i + 5).clear();
                flag = true;
            }
            i += 5;
        }
        if (flag) {
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(value.toString());
            br.close();
            fr.close();
        }
        return flag;
    }


}


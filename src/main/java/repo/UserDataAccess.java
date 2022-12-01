package repo;
import entities.User;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UserDataAccess implements UserDataAccessInterface{
    /**
     * userID, username, password, petIDs,  reportCounts
     * "0000001","student","password","1","0$0$0"
     * 0,         1,         2,       3,           4
     */
    static String defaultUserID = "00000001";
    static String defaultPetID = "00000001";
    static String defaultReportCount = "0$0$0";
    static String filename = "src/main/java/data/userData";
    @Override
    public User getUserById(String id) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        ArrayList<String> value = new ArrayList<String>();
        while ((line = br.readLine()) != null) {
            String[] a = line.split(",");
            value.addAll(List.of(a));
        }
        br.close();
        fr.close();
        int i = 0;
        while (i + 5 <= value.size()) {
            if (Objects.equals(value.get(i), id)) {
                return new User(id, value.get(i + 1), value.get(i + 2), value.get(i + 3), value.get(i + 4));
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
        ArrayList<String> value = new ArrayList<String>();
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
    public boolean saveUser(String userID, String username, String password, String petID, String reportCount) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        ArrayList<String> value = new ArrayList<String>();
        while((line = br.readLine()) != null){
            value.addAll(Arrays.asList(line.split(",")));
        }
        br.close();
        fr.close();
        int i = 0;
        boolean flag = false;
        while (i + 5 <= value.size() && !flag) {
            if (Objects.equals(value.get(i), userID)) {
                value.set(i+1, username);
                value.set(i+2, password);
                value.set(i+3, petID);
                value.set(i+4, reportCount);
                flag = true;
            }
            i += 5;
        }
        if (!flag) {
            String newUser = userID + "," + username + "," + password + "," + petID + "," + defaultReportCount;
            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(newUser);
            br.close();
            fr.close();
            return true;
        }
        else{
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(value.toString());
            br.close();
            fr.close();
            return true;
        }
    }

    @Override
    public boolean existsUsername(String username) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        ArrayList<String> value = new ArrayList<String>();
        while((line = br.readLine()) != null){
            value.addAll(Arrays.asList(line.split(",")));
        }
        br.close();
        fr.close();
        return value.contains(username);
    }

    @Override
    public User getUserByPetID(String petID) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        ArrayList<String> value = new ArrayList<String>();
        while((line = br.readLine()) != null){
            value.addAll(Arrays.asList(line.split(",")));
        }
        br.close();
        fr.close();
        int i = 3;
        while (i + 2 <= value.size()){
            if (Arrays.asList(value.get(i).split("\\$")).contains(petID)){
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
        ArrayList<String> value = new ArrayList<String>();
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


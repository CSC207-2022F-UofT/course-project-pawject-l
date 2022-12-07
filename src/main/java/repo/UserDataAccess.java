package repo;
import entities.User;
import useCase.Account.AccountRequestModel;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserDataAccess implements UserDataAccessInterface{

    /**
     * userID, username, password, petIDs,  reportCounts
     * "0000001","student","password","PET ID:0001$PET ID:0002","0$0$0"
     * 0,         1,         2,       3,           4
     */
    static String defaultReportCount = "0$0$0";
    static String filename = "src/main/java/data/userData";
    @Override
    public User getUserById(String id) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        br.readLine();//skip the header
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
        br.readLine();//skips the header
        while((line = br.readLine()) != null){
            String[] a = line.split(",");
            value.addAll(List.of(a));
        }
        br.close();
        fr.close();
        int i = 1;
        while (i + 4 <= value.size()){
            if (Objects.equals(value.get(i), username)){
                return new User(value.get(i - 1), username, value.get(i + 1), value.get(i+2), value.get(i+3));
            }
            i += 5;
        }
        return null;
    }

    @Override
    public boolean saveUser(String userID, String username, String password, String petID, String reportCount) throws IOException {
        Path path = Path.of(filename);
        List<String> fileContent = new ArrayList<>(Files.readAllLines(path, StandardCharsets.UTF_8));
        boolean flag = false;
        for (int i = 0; i < fileContent.size(); i++) {
            String line = fileContent.get(i);
            String[] value = line.split(",");
            if (Objects.equals(value[0], userID)) {
                String User = userID + "," + username + "," + password + "," + petID + "," + reportCount;
                fileContent.set(i, User);
                Files.write(path, fileContent, StandardCharsets.UTF_8);
                flag = true;
            }
        }
        if (!flag) {
            String newUser = userID + "," + username + "," + password + "," + petID + "," + defaultReportCount;
            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.append(newUser);
            bw.close();
            fw.close();
            return true;
        }
        return false;
    };

    @Override
    public boolean existsUsername(String username) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        ArrayList<String> value = new ArrayList<String>();
        while((line = br.readLine()) != null){
            String[] a = line.split(",");
            value.addAll(List.of(a));
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
            String[] a = line.split(",");
            value.addAll(List.of(a));
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
        Path path = Path.of(filename);
        List<String> fileContent = new ArrayList<>(Files.readAllLines(path, StandardCharsets.UTF_8));
        boolean flag = false;
        for (int i = 0; i < fileContent.size(); i++) {
            String line = fileContent.get(i);
            String[] value = line.split(",");
            if (Objects.equals(value[1], username)) {
                fileContent.remove(i);
                flag = true;
            }
        }
        Files.write(path, fileContent, StandardCharsets.UTF_8);
        return flag;
    }

    @Override
    public int CountUser() throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        int count = 0;
        while(br.readLine() != null){
            count += 1;
        }
        br.close();
        fr.close();
        return count;
    }
}

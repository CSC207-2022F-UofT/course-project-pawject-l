package repo;
import entities.User;
import useCase.Account.AccountRequestModel;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserDataAccess implements UserDataAccessInterface{
    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    static final Map<String, User> accounts = new HashMap<>();
    static String userID = "0";
    static String PetID = "0";
    static String ReportCount = "0$0$0";

    public UserDataAccess(String csvPath) throws IOException {
        csvFile = new File(csvPath);

        headers.put("userID", 0);
        headers.put("username", 1);
        headers.put("password", 2);
        headers.put("pet", 3);
        headers.put("reports", 4);

        if (csvFile.length() == 0) {
            save();
        } else {
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String userID = String.valueOf(col[headers.get("userID")]);
                String username = String.valueOf(col[headers.get("username")]);
                String password = String.valueOf(col[headers.get("password")]);
                String pet = String.valueOf(col[headers.get("pet")]);
                String report = String.valueOf(col[headers.get("report")]);
//                AccountRequestModel requestModel = new AccountRequestModel(username, password);
                User user = new User(userID, username, password, pet, report);
                accounts.put(username, user);
            }

            reader.close();
        }
    }

    public void save(User user) {
        accounts.put(user.getUsername(), user);
        this.save();
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {
                writer.write(user.getUserID() + ',' + user.getUsername() + ',' + user.getPassword() + ',' + PetID + ',' + ReportCount);
                writer.newLine();
            }
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean existsUser(String username) {
        return accounts.containsKey(username);
    }

    public User getUser(String username) {return accounts.get(username);}

//    public AccountRequestModel getReqMod(String username) { return accounts.get(username); }




    /**
     * userID, username, password, petIDs,  reportCounts
     * "0000001","student","password","PET ID:0001$PET ID:0002","0$0$0"
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
    public boolean saveUser(String userID, String username, String password) throws IOException {
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
                value.add(userID);
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


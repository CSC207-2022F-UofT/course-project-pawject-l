package entities;


import java.util.List;
public class User {

    public int userID;
    public String username;
    public static String password;
    private List<Pet> pets;
    private int reportCount;

    // constructor that doesn't take in pet
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(int user_id, String password, String username, int report_count) {
        this.userID = user_id;
        this.password = password;
        this.username = username;
        this.reportCount = 0;
    }
    public User(Pet pet){
        this.pets.add(pet);
    }

    public int getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public int getReportCount() {
        return reportCount;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setName(String name) {
        this.username = name;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void setReportCount(int reportCount) {
        this.reportCount = reportCount;
    }

    public static boolean checkPasswordValid() {
        if (password.length() < 6) {
            return false;
        } else {
            boolean checkLowerCase = false;
            boolean checkUpperCase = false;
            boolean checkNumber = false;
            for (char c : password.toCharArray()) {
                if (c == ' ') {
                    return false;
                } else if (Character.isLowerCase(c)) {
                    checkLowerCase = true;
                } else if (Character.isUpperCase(c)) {
                    checkUpperCase = true;
                } else if (Character.isDigit(c)) {
                    checkNumber = true;
                }
            }
            return checkLowerCase == checkUpperCase && checkUpperCase == checkNumber && checkLowerCase == checkNumber;
        }
    }
}


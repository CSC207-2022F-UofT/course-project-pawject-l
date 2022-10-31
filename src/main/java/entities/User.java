package entities;


import java.util.List;
public class User {

    private int user_id;
    public  String password;
    private String name;
    private List<Pet> pets;
    private int report_count;

    public User(int user_id, String password, String name, Pet pet) {
        this.user_id = user_id;
        this.password = password;
        this.name = name;
        this.pets.add(pet);
        this.report_count = 0;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getReport_count() {
        return report_count;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void setReport_count(int report_count) {
        this.report_count = report_count;
    }
}


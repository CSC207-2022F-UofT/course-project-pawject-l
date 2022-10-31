package entities;
import java.util.HashMap;
import java.util.List;
public class User {

    private int user_id;
    private  int password;
    private String name;
    private List<Pet> pets;
    private HashMap<String, Integer> report_count;

    public User(int user_id, int password, String name, Pet pet) {
        this.user_id = user_id;
        this.password = password;
        this.name = name;
        this.pets.add(pet);
        this.report_count = new HashMap<String, Integer>();
        this.report_count.put("Type_A", 0);
        this.report_count.put("Type_B", 0);
        this.report_count.put("Type_C", 0);
    }

    public int getUser_id() {
        return user_id;
    }

    public int getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public HashMap getReport_count() {
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

    public void setPassword(int password) {
        this.password = password;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void setReport_count(String key) {
        this.report_count.put(key, report_count.get(key)+1);
    }
}


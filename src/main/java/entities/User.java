package entities;
import java.util.HashMap;
import java.util.List;
public class User {

    private int user_id;
    public  String password;
    private String name;
    private List<Pet> pets;
    private HashMap<String, Integer> report_count;

    public User(int user_id, String password, String name, Pet pet) {
        this.user_id = user_id;
        this.password = password;
        this.name = name;
        this.pets.add(pet);
        this.report_count = new HashMap<String, Integer>();
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

    public int getReport_count(String key) {
        return report_count.get(key);
    }

    public List<Pet> getPets() {
        return pets;
    }
    public Pet getPet(int id){
        for(Pet pet: pets){
            if (pet.getPet_id() == id){
                return pet;
            }
        }
        return null;
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

    public void setReport_count(String key) {
        if (this.report_count.containsKey(key)) {
            this.report_count.put(key, report_count.get(key) + 1);
        }
        else {this.report_count.put(key, 1);}
    }
}


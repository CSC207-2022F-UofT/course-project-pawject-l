package entities;

import java.io.Serializable;
import java.util.List;


public class Attributes implements Serializable {

    private List<String> species;
    private List<String> breed; // allow for multiple preferred breeds
    private List<Integer> age; // allow for a range of preferred ages
    private String gender;
    private boolean vaccineStatus;



    public Attributes(List<String> species, List<String> breed, List<Integer> age, String gender,
                      boolean vaccineStatus){
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
        this.vaccineStatus = vaccineStatus;
    }

    public void setSpecies(List<String> species) {
        this.species = species;
    }
    public void setBreed(List<String> breed) {
        this.breed = breed;
    }

    public void setAge(List<Integer> age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setVaccineStatus(boolean vaccine_status) {
        this.vaccineStatus = vaccine_status;
    }

    public List<String> getSpecies() {
        return species;
    }
    public List<String> getBreed() {
        return breed;
    }

    public List<Integer> getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public boolean isVaccinated() {
        return vaccineStatus;
    }


}



package entities;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.List;
import java.awt.*;

public class Attributes implements Serializable {

    private List<String> species;
    private List<String> breed; // allow for multiple preferred breeds
    private List<Integer> age; // allow for a range of preferred ages
    private String gender;
    private float preferredProximity; // distance in KM
    private Image proofOfVaccination;
    private boolean vaccineStatus;
    private float longitude;
    private float latitude;

    private List<DayOfWeek> availableDay; // list of the available days of the week

    public Attributes(List<String> species, List<String> breed, List<Integer> age, String gender, Image proofOfVaccination,
                      boolean vaccineStatus, float longitude, float latitude, float preferredProximity, List<DayOfWeek> availableDay){
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
        this.proofOfVaccination = proofOfVaccination;
        this.vaccineStatus = vaccineStatus;
        this.longitude = longitude;
        this.latitude = latitude;
        this.preferredProximity = preferredProximity;
        this.availableDay = availableDay;
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

    public void setProofOfVaccination(Image proofOfVaccination){
        this.proofOfVaccination = proofOfVaccination;
    }

    public void setVaccineStatus(boolean vaccine_status) {
        this.vaccineStatus = vaccine_status;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
    public void setPreferredProximity(float preferredProximity) {
        this.preferredProximity = preferredProximity;
    }

    public void setAvailableDay(List<DayOfWeek> availableDay) {
        this.availableDay = availableDay;
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

    public Image getProofOfVaccination() {
        return proofOfVaccination;
    }

    public boolean isVaccinated() {
        return vaccineStatus;
    }

    public float getPreferredProximity() {
        return preferredProximity;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public List<DayOfWeek> getAvailableDay() {
        return availableDay;
    }


}




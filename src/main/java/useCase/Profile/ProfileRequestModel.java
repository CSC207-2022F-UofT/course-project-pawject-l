package useCase.Profile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.time.DayOfWeek;
import java.util.List;
import java.util.UUID;

public class ProfileRequestModel {
    private String name;
    private String description;

    private List<String> species;
    private List<String> breed; // allow for multiple preferred breeds
    private List<Integer> age; // allow for a range of preferred ages
    private String gender;
    boolean vaccineStatus;

    private List<String> preferredSpecies;
    private List<String> preferredBreed; // allow for multiple preferred breeds
    private List<Integer> preferredAge; // allow for a range of preferred ages
    private String preferredGender;
    private java.util.List<BufferedImage> images;
    private float preferredProximity; // distance in KM
    private List<DayOfWeek> availableDay; // list of the available days of the week
    private BufferedImage proofOfVaccination;
    private float longitude;
    private float latitude;

    private boolean preferredVaccineStatus;
    private String petId;




    public ProfileRequestModel(String name, String description,List<String> species, List<String> breed, List<Integer> age, String gender, boolean vaccineStatus,
                               List<String> preferredSpecies, List<String> preferredBreed, List<Integer> preferredAge, String preferredGender,
                               List<BufferedImage> images, BufferedImage proofOfVaccination, float longitude, float latitude, float preferredProximity,
                               List<DayOfWeek> availableDay, boolean preferredVaccineStatus, String petId) {
        this.name = name;
        this.description = description;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
        this.vaccineStatus = vaccineStatus;
        this.preferredSpecies = preferredSpecies;
        this.preferredBreed = preferredBreed;
        this.preferredAge = preferredAge;
        this.preferredGender = preferredGender;
        this.images = images;
        this.proofOfVaccination = proofOfVaccination;
        this.longitude = longitude;
        this.latitude = latitude;
        this.preferredProximity = preferredProximity;
        this.availableDay = availableDay;
        this.preferredVaccineStatus = preferredVaccineStatus;
        this.petId = petId;
    }


    public String getPetId() {
        return petId;
    }
    public void setPetId(String petId){
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(List<Integer> age) {
        this.age = age;
    }

    public List<Integer> getAge() {
        return age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBreed(List<String> breed) {
        this.breed = breed;
    }

    public String getGender() {
        return gender;
    }

    public List<String> getBreed() {
        return breed;
    }

    public boolean getVaccineStatus(){
        return vaccineStatus;
    }

    public void setVaccineStatus(boolean vaccineStatus){
        this.vaccineStatus = vaccineStatus;
    }

    public void setAvailableDay(List<DayOfWeek> availableDay) {
        this.availableDay = availableDay;
    }

    public List<DayOfWeek> getAvailableDay() {
        return availableDay;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public BufferedImage getProofOfVaccination() {
        return proofOfVaccination;
    }

    public String getDescription() {
        return description;
    }

    public float getPreferredProximity() {
        return preferredProximity;
    }

    public String getPreferredGender() {
        return preferredGender;
    }

    public List<String> getPreferredSpecies() {
        return preferredSpecies;
    }

    public List<Integer> getPreferredAge() {
        return preferredAge;
    }

    public List<BufferedImage> getImages() {
        return images;
    }

    public List<String> getPreferredBreed() {
        return preferredBreed;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getSpecies() {
        return species;
    }

    public void setImages(List<BufferedImage> images) {
        this.images = images;
    }

    public void setSpecies(List<String> species) {
        this.species = species;
    }

    public void setPreferredSpecies(List<String> preferredSpecies) {
        this.preferredSpecies = preferredSpecies;
    }

    public void setPreferredAge(List<Integer> preferredAge) {
        this.preferredAge = preferredAge;
    }

    public void setPreferredBreed(List<String> preferredBreed) {
        this.preferredBreed = preferredBreed;
    }

    public void setPreferredGender(String preferredGender) {
        this.preferredGender = preferredGender;
    }

    public void setPreferredProximity(float preferredProximity) {
        this.preferredProximity = preferredProximity;
    }

    public void setProofOfVaccination(BufferedImage proofOfVaccination) {
        this.proofOfVaccination = proofOfVaccination;
    }

    public void setPreferredVaccineStatus(boolean preferredVaccineStatus) {
        this.preferredVaccineStatus = preferredVaccineStatus;
    }

    public boolean getPreferredVaccineStatus() {
        return preferredVaccineStatus;
    }
}

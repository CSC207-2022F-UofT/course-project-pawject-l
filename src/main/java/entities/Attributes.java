package entities;

import java.time.DayOfWeek;
import java.util.List;

public class Attributes {
    private String breed;
    private int age;
    private String gender;
    private int preferredProximity; // distance in KM
    private boolean vaccineStatus;
    private int longitude;
    private int latitude;

    private List<DayOfWeek> availableDay; // list of the available days of the week

    public Attributes(String breed, int age, String gender, int preferredProximity,
                      boolean vaccineStatus, int longitude, int latitude, DayOfWeek day){
        this.breed = breed;
        this.age = age;
        this.gender = gender;
        this.vaccineStatus = vaccineStatus;
        this.longitude = longitude;
        this.latitude = latitude;
        this.preferredProximity = preferredProximity;
        this.availableDay.add(day);
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setVaccineStatus(boolean vaccine_status) {
        this.vaccineStatus = vaccine_status;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
    public void setPreferredProximity(int preferredProximity) {
        this.preferredProximity = preferredProximity;
    }

    public void setAvailableDay(List<DayOfWeek> availableDay) {
        this.availableDay = availableDay;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public boolean isVaccinated() {
        return vaccineStatus;
    }

    public int getPreferred_proximity() {
        return preferredProximity;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public List<DayOfWeek> getAvailableDay() {
        return availableDay;
    }


}



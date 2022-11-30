package entities;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.nio.Buffer;
import java.time.DayOfWeek;
import java.util.List;

public class Pet implements Serializable {

    private String name;
    private String petID;
    private String description;
    private Attributes attributes;
    private Attributes preferredAttributes;
    private List<BufferedImage> images;
    private List<String> dislikes;
    private List<String> likes;
    private List<String> matches;

    private float preferredProximity; // distance in KM
    private List<DayOfWeek> availableDay; // list of the available days of the week
    private BufferedImage proofOfVaccination;

    private float longitude;

    private float latitude;

    public Pet(String name, String petID, String description, Attributes attributes, Attributes preferredAttributes,
               List<BufferedImage> images, BufferedImage proofOfVaccination, float longitude, float latitude, float preferredProximity, List<DayOfWeek> availableDay) {
        this.name = name;
        this.petID = petID;
        this.description = description;
        this.attributes = attributes;
        this.preferredAttributes = preferredAttributes;
        this.images = images;
        this.proofOfVaccination = proofOfVaccination;
        this.longitude = longitude;
        this.latitude = latitude;
        this.preferredProximity = preferredProximity;
        this.availableDay = availableDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPetID() {
        return petID;
    }

    public void setPetId(String petID) {
        this.petID = petID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Attributes getPreferredAttributes() {
        return preferredAttributes;
    }

    public void setPreferredAttributes(Attributes preferredAttributes) {
        this.preferredAttributes = preferredAttributes;
    }

    public List<BufferedImage> getImages() {
        return images;
    }

    public void setImages(List<BufferedImage> images) {
        this.images = images;
    }

    public void setProofOfVaccination(BufferedImage proofOfVaccination){
        this.proofOfVaccination = proofOfVaccination;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setPreferredProximity(float preferredProximity) {
        this.preferredProximity = preferredProximity;
    }

    public void setAvailableDay(List<DayOfWeek> availableDay) {
        this.availableDay = availableDay;
    }

    public BufferedImage getProofOfVaccination() {
        return proofOfVaccination;
    }

    public float getPreferredProximity() {
        return preferredProximity;
    }

    public List<DayOfWeek> getAvailableDay() {
        return availableDay;
    }

    public List<String> getDislikes() {
        return dislikes;
    }

    public void setDislikes(List<String> dislikes) {
        this.dislikes = dislikes;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    public List<String> getMatches() {return matches;}

    public void setMatches(List<String> matches) {
        this.matches = matches;
    }

    public void addLikes(String pet) {
        this.likes.add(pet);
    }

    public void addDislikes(String pet) {
        this.dislikes.add(pet);
    }

    public void addMatches(String pet) {
        this.matches.add(pet);
    }

    public void removeLikes(String pet) {
        this.likes.remove(pet);
    }

    public void removeDislikes(String pet) {
        this.dislikes.remove(pet);
    }

    public void removeMatches(String pet) {
        this.matches.remove(pet);
    }

}

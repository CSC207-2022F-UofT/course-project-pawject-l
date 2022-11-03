package entities;

import java.awt.*;
import java.util.List;

public class Pet {

    private String name;
    private String petId;
    private String description;
    private Attributes attributes;
    private Attributes preferredAttributes;
    private Image image;
    private List<Pet> dislikes;
    private List<Pet> likes;
    private List<Pet> matches;

    public Pet(String name, String petId, String description, Attributes attributes, Attributes preferredAttributes,
               Image image) {
        this.name = name;
        this.petId = petId;
        this.description = description;
        this.attributes = attributes;
        this.preferredAttributes = preferredAttributes;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<Pet> getDislikes() {
        return dislikes;
    }

    public void setDislikes(List<Pet> dislikes) {
        this.dislikes = dislikes;
    }

    public List<Pet> getLikes() {
        return likes;
    }

    public void setLikes(List<Pet> likes) {
        this.likes = likes;
    }

    public List<Pet> getMatches() {
        return matches;
    }

    public void setMatches(List<Pet> matches) {
        this.matches = matches;
    }

    public void addLikes(Pet pet) {
        this.likes.add(pet);
    }

    public void addDislikes(Pet pet) {
        this.dislikes.add(pet);
    }

    public void addMatches(Pet pet) {
        this.matches.add(pet);
    }

    public void removeLikes(Pet pet) {
        this.likes.remove(pet);
    }

    public void removeDislikes(Pet pet) {
        this.dislikes.remove(pet);
    }

    public void removeMatches(Pet pet) {
        this.matches.remove(pet);
    }

}

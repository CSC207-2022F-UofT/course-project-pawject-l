package entities;

import java.awt.*;
import java.util.List;

public class Pet {

    private String name;
    private int pet_id;
    private String description;
    private List<Attributes> attributes;
    private List<Attributes> preferred_attributes;
    private Image image;
    private List<Pet> dislikes;
    private List<Pet> likes;
    private List<Pet> matches;
    private List<Chat> chats;

    public Pet(String name, int pet_id, String description, List<Attributes> attributes, List<Attributes> preferred_attributes,
               Image image) {
        this.name = name;
        this.pet_id = pet_id;
        this.description = description;
        this.attributes = attributes;
        this.preferred_attributes = preferred_attributes;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPet_id() {
        return pet_id;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Attributes> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attributes> attributes) {
        this.attributes = attributes;
    }

    public List<Attributes> getPreferred_attributes() {
        return preferred_attributes;
    }

    public void setPreferred_attributes(List<Attributes> preferred_attributes) {
        this.preferred_attributes = preferred_attributes;
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

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
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

    public void addChats(Chat chat) {
        this.chats.add(chat);
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

    public void removeChats(Chat chat) {
        this.chats.remove(chat);
    }
}

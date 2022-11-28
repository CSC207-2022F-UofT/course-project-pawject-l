import entities.Attributes;
import entities.Pet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import userCase.ProfileRequest;

import java.awt.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;

public class ProfileRequestTest {

    @Test
    public void generatePetID(){
        ArrayList<String> pet1Species = new ArrayList<>();
        pet1Species.add("dog");
        ArrayList<String> pet1Breed= new ArrayList<>();
        pet1Species.add("poodle");
        ArrayList<Integer> pet1Age = new ArrayList<>();
        pet1Age.add(3);
        ArrayList<DayOfWeek> pet1Days = new ArrayList<>();
        pet1Days.add(DayOfWeek.FRIDAY);
        pet1Days.add(DayOfWeek.SATURDAY);

        Image image = null;
        ArrayList<Image> images = null;
        Attributes attributesPet1 = new Attributes( pet1Species, pet1Breed, pet1Age, "F",
                image, true, 100, 200, 5, pet1Days);
        Pet pet1 = new Pet("Pet 1", "Pet ID: 1", "description 1", attributesPet1, attributesPet1, images);

        HashMap<String, Pet> existingPetByIDs = new HashMap<>();
        existingPetByIDs.put("Pet ID: 1", pet1);

        Attributes attibutesPet2 = new Attributes( pet1Species, pet1Breed, pet1Age, "M",
                image, true, 100, 200, 5, pet1Days);
        Attributes preferredAttibutesPet2 = new Attributes( pet1Species, pet1Breed, pet1Age, "M",
                image, true, 100, 200, 5, pet1Days);

        ProfileRequest.createNewProfile(existingPetByIDs, "Pet 2", "description 2", attibutesPet2, preferredAttibutesPet2, images);

        Assertions.assertEquals("Pet ID: 2", ProfileRequest.generatePetID(existingPetByIDs));
    }

    @Test
    public void profileExistsTest(){
        ArrayList<String> pet1Species = null;
        ArrayList<String> pet1Breed= null;
        ArrayList<Integer> pet1Age = null;
        ArrayList<DayOfWeek> pet1Days = null;

        Image image = null;
        ArrayList<Image> images = null;
        Attributes attributesPet1 = new Attributes( pet1Species, pet1Breed, pet1Age, "F",
                image, true, 100, 200, 5, pet1Days);
        Pet pet1 = new Pet("Pet 1", "Pet ID: 1", "description 1", attributesPet1, attributesPet1, images);

        HashMap<String, Pet> existingPetByIDs = new HashMap<>();
        existingPetByIDs.put("Pet ID: 1", pet1);

        Attributes attributesPet2 = new Attributes( pet1Species, pet1Breed, pet1Age, "M",
                image, true, 100, 200, 5, pet1Days);
        Attributes preferredAttributesPet2 = new Attributes( pet1Species, pet1Breed, pet1Age, "M",
                image, true, 100, 200, 5, pet1Days);

        ProfileRequest.createNewProfile(existingPetByIDs, "Pet 2", "description 2", attributesPet2, preferredAttributesPet2, images);

        Assertions.assertTrue(ProfileRequest.profileExists("Pet ID: 2"));

    }

    @Test
    public void testEditName(){
        Pet pet1 = new Pet("Pet 1", "Pet ID: 1", "description 1", null, null, null);
        ProfileRequest.editName("Pet ID: 1", "Pet A");
        Assertions.assertEquals("Pet A",pet1.getName());
    }


}

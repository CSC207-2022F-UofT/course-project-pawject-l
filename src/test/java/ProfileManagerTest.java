import entities.Attributes;
import org.junit.jupiter.api.Assertions;

import repo.PetDataAccessInterface;
import repo.PetDataAccess;
import entities.Pet;

import org.junit.jupiter.api.Test;
import useCase.Profile.ProfileInputBoundary;
import useCase.Profile.ProfileManager;
import controller.ProfileController;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProfileManagerTest {
    PetDataAccessInterface ds = new PetDataAccess();
    ProfileInputBoundary pib = new ProfileManager(ds);
    ProfileController pc = new ProfileController(pib);

    @Test
    public void ProfileCreationTest() throws IOException {
        String name = "Pet1";
        String bio = "This is my bio";
        List<String> breeds = new ArrayList<>();
        breeds.add("Breed1");
        List<String> species = new ArrayList<>();
        species.add("Spec1");
        List<Integer> ages = new ArrayList<>();
        ages.add(5);
        String gender = "male";
        boolean vaccineStatus = false;
        List<BufferedImage> petPhotos = new ArrayList<>();
        BufferedImage petPhoto = ImageIO.read(new File("src/main/java/data/Images/image2.jpg"));
        petPhotos.add(petPhoto);
        BufferedImage vaccineImage = ImageIO.read(new File("src/main/java/data/NOVAX.jpg"));
        float longitude = (float) 100.8;
        float latitude = (float) 80.99;
        float proximity = 8;
        List<DayOfWeek> availableDays = new ArrayList<>();
        availableDays.add(DayOfWeek.SUNDAY);
        availableDays.add(DayOfWeek.FRIDAY);
        String petID = "Pet ID: " + UUID.randomUUID();



        pc.performProfileCreation(name, bio, species, breeds, ages, gender, vaccineStatus, species,
                breeds, ages, gender, petPhotos, vaccineImage, longitude, latitude, proximity,
                availableDays,vaccineStatus, petID);

        Pet petA = ds.getPetById(petID);

        Assertions.assertEquals(petA.getPetID(), petID);
        Assertions.assertEquals(petA.getName(), name);
        Assertions.assertEquals(petA.getLatitude(), latitude);
        Assertions.assertEquals(petA.getLongitude(), longitude);
        Assertions.assertEquals(petA.getAvailableDay(), availableDays);
        Assertions.assertEquals(petA.getDescription(), bio);
        Assertions.assertEquals(petA.getPreferredProximity(), proximity);
        Assertions.assertEquals(petA.getAttributes().getAge(), ages);
        Assertions.assertEquals(petA.getPreferredAttributes().getAge(), ages);
        Assertions.assertEquals(petA.getAttributes().getBreed(), breeds);
        Assertions.assertEquals(petA.getPreferredAttributes().getBreed(), breeds);
        Assertions.assertEquals(petA.getPreferredAttributes().getGender(), gender);
        Assertions.assertEquals(petA.getAttributes().getGender(), gender);
        Assertions.assertEquals(petA.getAttributes().getSpecies(), species);
        Assertions.assertEquals(petA.getPreferredAttributes().getSpecies(), species);
        Assertions.assertEquals(petA.getPreferredAttributes().isVaccinated(), vaccineStatus);
        Assertions.assertEquals(petA.getAttributes().isVaccinated(), vaccineStatus);

    }

}

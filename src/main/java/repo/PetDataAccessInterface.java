package repo;

import entities.Attributes;
import entities.User;
import entities.Pet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface PetDataAccessInterface {

    Pet getPetById(String id) throws IOException;

    /**
     * Get all pets given a user.
     * @param user
     * @return Hashmap with keys as the id and values as Pet object
     */
    HashMap<String, Pet> getPetsByUser(User user) throws IOException;

    /**
     * Get a pet given the user and the pet name.
     * @param user
     * @param name
     * @return Pet
     */
    Pet getPetByUserAndName(User user, String name) throws IOException;

    /**
     * Get pets given the user and the pet type (cat, dog, etc.)
     * @param user
     * @param typeOfPet
     * @return Pet
     */
    HashMap<String, Pet> getPetsByUserAndType(User user, String typeOfPet) throws IOException;

    /**
     * Get a random pet
     *
     * @return Pet
     */
    Pet getRandomPet() throws IOException;

    /**
     * Saves pet in database. Returns true if saved, false if not.
     * @param pet
     * @return true if saved, false if not
     */

    boolean savePet(Pet pet) throws IOException;

    // Let me know if you would like other methods (e.g. to get a specific pet given a user and an attribute(s)).

}

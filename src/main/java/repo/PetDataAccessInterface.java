package repo;

import entities.Attributes;
import entities.User;
import entities.Pet;

import java.util.HashMap;
import java.util.List;

public interface PetDataAccessInterface {

    Pet getPetById(String id);

    /**
     * Get all pets given a user.
     * @param user
     * @return Hashmap with keys as the id and values as Pet object
     */
    HashMap<String, Pet> getPetsByUser(User user);

    /**
     * Get a pet given the user and the pet name.
     * @param user
     * @param name
     * @return Pet
     */
    Pet getPetByUserAndName(User user, String name);

    /**
     * Get a pet given the user and the pet type (cat, dog, etc.)
     * @param user
     * @param typeOfPet
     * @return Pet
     */
    Pet getPetByUserAndType(User user, String typeOfPet);

    /**
     * Get a random pet
     *
     * @return Pet
     */
    Pet getRandomPet();

    /**
     * Saves pet in database. Returns true if saved, false if not.
     * @param pet
     * @return true if saved, false if not
     */

    boolean savePet(Pet pet);

    // Let me know if you would like other methods (e.g. to get a specific pet given a user and an attribute(s)).

}

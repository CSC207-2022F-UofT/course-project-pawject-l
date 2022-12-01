package repo;

import entities.User;
import entities.Pet;

import java.io.IOException;

public interface PetDataAccessInterface {
    /**
     * Get Pet based on given ID
     * @param id id of Pet
     * @return Pet
     */
    Pet getPetById(String id) throws IOException;
    /**
     * Get Pet name based on given ID
     * @param id id of Pet
     * @return given Pet's name
     */
    String getPetNameById(String id) throws IOException;
    /**
     * Creates String object containing a user's petId
     *
     * @param user the User object used to find specific petId
     * @return Returns String object containing petId
     */
    String getPetIdByUser(User user);
    /**
     * Get a random pet
     *
     * @return Pet
     */
    Pet getRandomPet() throws IOException;

    /**
     * Saves pet in database. Returns true if saved, false if not.
     * @param pet pet Object being saved.
     * @return true if saved, false if not
     */

    boolean savePet(Pet pet) throws IOException;

    /**
     * Updates a pet already existing in the database, returns true if updated.
     * @param pet pet Object being saved.
     * @return true if updated, false if update fails.
     */
    boolean updatePet(Pet pet) throws IOException;

    // Let me know if you would like other methods (e.g. to get a specific pet given a user and an attribute(s)).

}

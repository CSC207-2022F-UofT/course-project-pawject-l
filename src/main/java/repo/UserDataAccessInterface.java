package repo;

import entities.User;
import useCase.Account.AccountRequestModel;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface UserDataAccessInterface {

    User getUserById(String id) throws IOException;

    /**
     * Get User given a unique username.
     * Note: if we don't want a unique username, please comment out/delete this method
     * and the last method (existsUsername).
     * @param username
     * @return
     */
    User getUserByUsername(String username) throws IOException;

    /**
     * Saves user in database. Returns true if saved, false if not.
     * @param username
     * @param password
     * @return true if saved, false if not
     */
    boolean saveUser(String userID, String username, String password, String petID, String reportCount) throws IOException;


    /**
     * Checks if a given username already exists in the database. Returns true if it exists, false if it does not.
     * @param username
     * @return true if username is already in use, false if not
     */
    boolean existsUsername(String username) throws IOException;
    User getUserByPetID(String petID) throws IOException;
    /**
     * Get User given a unique petID.
     * @param username
     * @return the user
     */
    boolean deleteUser(String username) throws IOException;
    /**
     * Delete the user.
     */
    int CountUser() throws IOException;

    // Let me know if you would like other methods (e.g. to get a user by some other identifier).

}
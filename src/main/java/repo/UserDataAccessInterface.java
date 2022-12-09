package repo;

import entities.User;
import useCase.Account.AccountRequestModel;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface UserDataAccessInterface {
    /**
     * Get User given a unique userID
     * @param id
     * @return user
     * @throws IOException
     */
    User getUserById(String id) throws IOException;

    /**
     * Get User given a unique username.
     * Note: if we don't want a unique username, please comment out/delete this method
     * and the last method (existsUsername).
     * @param username
     * @return user
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
    /**
     * Get User given a unique petID.
     * @param petID
     * @return the user
     */
    User getUserByPetID(String petID) throws IOException;

    /**
     * Deletes the user.
     * @return true if the deletion is successful.
     * @throws IOException
     */
    boolean deleteUser(String username) throws IOException;

    /**
     * Counts the number of the users in the database.
     * @return the number of the users in the database
     * @throws IOException
     */
    int CountUser() throws IOException;


    // Let me know if you would like other methods (e.g. to get a user by some other identifier).

}
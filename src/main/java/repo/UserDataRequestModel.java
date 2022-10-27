package repo;

import entities.User;

public interface UserDataRequestModel {

    User getUserById(String id);

    /**
     * Get User given a unique username.
     * Note: if we don't want a unique username, please comment out/delete this method
     * and the last method (existsUsername).
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * Saves user in database. Returns true if saved, false if not.
     * @param user
     * @return true if saved, false if not
     */
    boolean saveUser(User user);

    /**
     * Checks if a given username already exists in the database. Returns true if it exists, false if it does not.
     * @param username
     * @return true if username is already in use, false if not
     */
    boolean existsUsername(String username);

    // Let me know if you would like other methods (e.g. to get a user by some other identifier).

}
package DataAccess;

import Model.User;

public class UserDao {


    /**
     * creates a new user account
     * @param user
     */
    void createUser(User user){

    }


    /**
     * logs the user in
     * @param username
     * @param password
     * @return true or false if the info is correct/incorrect
     */
    boolean validate(String username, String password){
        return false;
    }

    /**
     * find the user by the ID
     * @param userID
     * @return this should return an authtoken???
     */
    User getUserById(String userID){
        return null;
    }
}

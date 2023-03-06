package DataAccess;

import Model.Person;
import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {


    private final Connection conn;

    /**
     * establishing a connection to database
     *
     * @param conn
     */

    public UserDao(Connection conn) {
        this.conn = conn;
    }

    /**
     * creates a new user account
     *
     * @param user
     */
    void createUser(User user) {

    }


    /**
     * logs the user in
     *
     * @param username
     * @param password
     * @return true or false if the info is correct/incorrect
     */
    boolean validate(String username, String password) {
        return false;
    }

    /**
     * find the user by the ID
     *
     * @param userID
     * @return this should return an authtoken???
     */
    User getUserById(String userID) {
        return null;
    }


    /**
     * insert function
     *
     * @param user
     * @throws DataAccessException
     */
    public void insert(User user) throws DataAccessException {
        //We can structure our string to be similar to a sql command, but if we insert question
        //marks we can change them later with help from the statement
        String sql = "INSERT INTO User (username, password, email, firstName, lastName, gender, personID ) VALUES(?,?,?,?,?,?,?)";

        try (
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            //Using the statements built-in set(type) functions we can pick the question mark we want
            //to fill in and give it a proper value. The first argument corresponds to the first
            //question mark found in our sql String
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getFirstName());
            stmt.setString(5, user.getLastName());
            stmt.setString(6, user.getGender());
            stmt.setString(7, user.getPersonID());


            stmt.executeUpdate();
        } catch (
                SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("Error encountered while inserting an event into the database");
        }
    }


    public User findUser(String username) throws DataAccessException {

        User user;
        ResultSet rs;
        String sql = "SELECT * FROM User WHERE username = ?;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User(rs.getString("username"), rs.getString("password"),
                        rs.getString("email"), rs.getString("firstName"), rs.getString("lastName"),
                        rs.getString("gender"), rs.getString("personID"));


                return user;


            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("Error encountered while finding an event in the database");
        }
    }

    /**
     * clear function, clear the data table
     * @throws DataAccessException
     */
    public void clear() throws DataAccessException {
        String sql = "DELETE FROM User";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("Error encountered while clearing the event table");
        }
    }
}

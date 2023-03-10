package DataAccess;




import Model.Event;
import Model.Person;

import java.sql.*;
import java.util.List;



public class PersonDao {

    private final Connection conn;

    /**
     * establishing a connection to database
     * @param conn
     */

    public PersonDao(Connection conn) {this.conn = conn;}




    /**
     * finds a single person object according to the personID
     * @param personID
     * @return the person object
     */
    public Person findPerson(String personID) throws DataAccessException{

            Person person;
            ResultSet rs;
            String sql = "SELECT * FROM Person WHERE personID = ?;";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, personID);
                rs = stmt.executeQuery();
                if (rs.next()) {
                    person = new Person(rs.getString("personID"), rs.getString("associatedUsername"),
                            rs.getString("firstName"), rs.getString("lastName"), rs.getString("gender"),
                            rs.getString("fatherID"), rs.getString("motherID"), rs.getString("spouseID"));


                    return person;

                } else {
                    return null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new DataAccessException("Error encountered while finding an event in the database");
            }




    }
    public void insert(Person person) throws DataAccessException {
        //We can structure our string to be similar to a sql command, but if we insert question
        //marks we can change them later with help from the statement
        String sql = "INSERT INTO Person (personID, associatedUsername, firstName, lastName, gender, fatherID, motherID, spouseID) VALUES(?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            //Using the statements built-in set(type) functions we can pick the question mark we want
            //to fill in and give it a proper value. The first argument corresponds to the first
            //question mark found in our sql String
            stmt.setString(1, person.getPersonID());
            stmt.setString(2, person.getAssociatedUsername());
            stmt.setString(3, person.getFirstName());
            stmt.setString(4, person.getLastName());
            stmt.setString(5, person.getGender());
            stmt.setString(6, person.getFatherID());
            stmt.setString(7, person.getMotherID());
            stmt.setString(8, person.getSpouseID());



            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("Error encountered while inserting an event into the database");
        }
    }

    /**
     * clears data
     * @throws DataAccessException
     */
    public void clear() throws DataAccessException{
    String sql = "DELETE FROM Person";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        throw new DataAccessException("Error encountered while clearing the event table");
    }
}


    /**
     * find a list of all the family members of user
     * @param personID
     * @return list of all the family members of the current user
     * @throws DataAccessException
     */
    public List<Person> findFamily(String personID) throws DataAccessException{

        return null;
    }







}

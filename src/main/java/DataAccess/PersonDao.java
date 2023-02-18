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
     * inserts a person into the database
     * @param person
     * @throws DataAccessException
     */
    public void insert(Person person) throws DataAccessException {
    }



    /**
     * finds a single person object according to the personID
     * @param personID
     * @return the person object
     */
    public Person findPerson(String personID) throws DataAccessException{
        return null;
    }

    /**
     * clears data
     * @throws DataAccessException
     */
    public void clear() throws DataAccessException{}


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

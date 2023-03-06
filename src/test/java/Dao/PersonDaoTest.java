package Dao;

import DataAccess.DataAccessException;
import DataAccess.Database;
import DataAccess.PersonDao;
import Model.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

public class PersonDaoTest {
    private Database db;
    private Person person;
    private PersonDao personDao;

    @BeforeEach
    public void setUp() throws DataAccessException {

        db = new Database();

        person = new Person("00001", "jeenulee", "Jeenu", "Lee", "m", "fatherId", "motherId", "spouseId");
        Connection conn = db.getConnection();
        personDao = new PersonDao(conn);

        personDao.clear();
    }

    @AfterEach
    public void tearDown() {

        db.closeConnection(false);
    }

    @Test
    public void insertPass() throws DataAccessException {
        personDao.insert(person);
        Person compareTest = personDao.findPerson(person.getPersonID());
        assertNotNull(compareTest);
        assertEquals(person, compareTest);
    }

    @Test
    public void insertFail() throws DataAccessException {
        personDao.insert(person);
        assertThrows(DataAccessException.class, () -> personDao.insert(person));
    }

    @Test
    public void findPass() throws DataAccessException {
        personDao.insert(person);
        Person compareTest = personDao.findPerson(person.getPersonID());
        assertNotNull(compareTest);
        assertEquals(person, compareTest);
    }

    @Test
    public void findFail() throws DataAccessException {
        Person compareTest = personDao.findPerson(person.getPersonID());
        assertNull(compareTest);
    }

    @Test
    public void clearPass() throws DataAccessException {
        personDao.insert(person);
        Person tempPerson = personDao.findPerson(person.getPersonID());
        personDao.clear();
        Person fakePerson = personDao.findPerson(person.getPersonID());

        assertNotNull(tempPerson);
        assertNull(fakePerson);
    }
}
package Dao;

import DataAccess.DataAccessException;
import DataAccess.Database;
import DataAccess.PersonDao;
import DataAccess.UserDao;
import Model.Person;
import Model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {
    private Database db;
    private User user;
    private UserDao userDao;

    @BeforeEach
    public void setUp() throws DataAccessException {
        // Create a new Database
        db = new Database();
        // Create a new user with random data
        user = new User("Jeenu", "IloveFood123", "jeenu3@byu.edu", "Jeenu", "Lee", "m", "00001");
        // Open database connection
        Connection conn = db.getConnection();
        //Then we pass that connection to the EventDAO, so it can access the database.
        userDao = new UserDao(conn);
        //Let's clear the database as well so any lingering data doesn't affect our tests
        userDao.clear();
    }

    @AfterEach
    public void tearDown() {
        // Here we close the connection to the database file, so it can be opened again later.
        // We will set commit to false because we do not want to save the changes to the database between test cases.
        db.closeConnection(false);
    }

    @Test
    public void insertPass() throws DataAccessException {
        userDao.insert(user);
        User compareTest = userDao.findUser(user.getUserName());
        assertNotNull(compareTest);
        assertEquals(user, compareTest);
    }

    @Test
    public void insertFail() throws DataAccessException {
        userDao.insert(user);
        assertThrows(DataAccessException.class, () -> userDao.insert(user));
    }

    @Test
    public void findPass() throws DataAccessException {
        userDao.insert(user);
        User compareTest = userDao.findUser(user.getUserName());
        assertNotNull(compareTest);
        assertEquals(user, compareTest);
    }

    @Test
    public void findFail() throws DataAccessException {
        User compareTest = userDao.findUser(user.getUserName());
        assertNull(compareTest);
    }

    @Test
    public void clearPass() throws DataAccessException {
        userDao.insert(user);
        User tempPerson = userDao.findUser(user.getUserName());
        userDao.clear();
        User fakePerson = userDao.findUser(user.getUserName());

        assertNotNull(tempPerson);
        assertNull(fakePerson);
    }

}

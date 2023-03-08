package Dao;

import DataAccess.DataAccessException;
import DataAccess.Database;
import DataAccess.UserDao;
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

        db = new Database();

        user = new User("Jeenu", "IloveFood123", "jeenu3@byu.edu", "Jeenu", "Lee", "m", "00001");
        // Opening the database
        Connection conn = db.getConnection();
        userDao = new UserDao(conn);
        userDao.clear();
    }

    @AfterEach
    public void close() {
        db.closeConnection(false);
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
    public void clearPass() throws DataAccessException {
        userDao.insert(user);
        User temp = userDao.findUser(user.getUserName());
        userDao.clear();
        User fakePerson = userDao.findUser(user.getUserName());

        assertNotNull(temp);
        assertNull(fakePerson);
    }

}

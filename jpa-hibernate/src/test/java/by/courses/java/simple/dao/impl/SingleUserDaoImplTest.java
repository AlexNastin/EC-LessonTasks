package by.courses.java.simple.dao.impl;

import by.courses.java.simple.dao.UserDao;
import by.courses.java.simple.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

//@FixMethodOrder(NAME_ASCENDING)
public class SingleUserDaoImplTest {

    private UserDao userDao;

    private User testUser;

    @Before
    public void setUp() {
        userDao = new UserDaoImpl();
        testUser = new User("Bruce");
        System.out.println("----- Test user: " + testUser);
    }

    @Test
    public void testCreateSingleUser() {
        User createdUser = userDao.create(testUser);
        System.out.println("----- Created user: " + createdUser);

        assertNotNull(createdUser.getId());
    }

    @Test
    public void testFindSingleUser() {
        User createdUser = userDao.create(testUser);
        System.out.println("----- Created user: " + createdUser);

        User foundUser = userDao.find(createdUser.getId());
        System.out.println("----- Found user: " + foundUser);

        assertNotNull(foundUser);
        assertEquals(createdUser.getId(), foundUser.getId());
        assertEquals(createdUser.getName(), foundUser.getName());
    }

    @Test
    public void testFindAllSingleUser() {
        User createdUser1 = userDao.create(testUser);
        System.out.println("----- Created user #1: " + createdUser1);
        User createdUser2 = userDao.create(new User("Robin"));
        System.out.println("----- Created user #2: " + createdUser2);

        List<User> users = userDao.findAll();

        assertEquals(2, users.size());
    }

    @Test
    public void testUpdateSingleUser() {
        User createdUser = userDao.create(testUser);
        System.out.println("----- Created user: " + createdUser);

        createdUser.setName("Batman");
        User updatedUser = userDao.update(createdUser);
        System.out.println("----- Updated user: " + updatedUser);

        assertNotNull(updatedUser);
        assertEquals(createdUser.getId(), updatedUser.getId());
        assertEquals(createdUser.getName(), updatedUser.getName());
    }

    @Test
    public void testDeleteSingleUser() {
        User createdUser = userDao.create(testUser);
        System.out.println("----- Created user: " + createdUser);

        Long id = createdUser.getId();
        userDao.delete(id);
        User deletedUser = userDao.find(id);

        assertNull(deletedUser);
    }

}
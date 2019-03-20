package by.courses.java.simple.dao.impl;

import by.courses.java.simple.dao.UserDao;
import by.courses.java.simple.entity.Role;
import by.courses.java.simple.entity.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManyToManyUserDaoImplTest {

    private UserDao userDao;
    private User testUser1;
    private User testUser2;

    @Before
    public void setUp() {
        userDao = new UserDaoImpl();

        Role testRole1 = new Role("Submitter");
        System.out.println("----- Test role #1: " + testRole1);

        Role testRole2 = new Role("Producer");
        System.out.println("----- Test role #2: " + testRole2);

        testUser1 = new User("Willy");
        testUser2 = new User("Billy");

        testRole1.getUsers().add(testUser1);
        testUser1.getRoles().add(testRole1);

        testRole2.getUsers().add(testUser1);
        testUser1.getRoles().add(testRole2);

        testRole2.getUsers().add(testUser2);
        testUser2.getRoles().add(testRole2);

        System.out.println("----- Test user #1: " + testUser1);
        System.out.println("----- Test user #2: " + testUser2);

    }

    @Test
    public void testCreateUser() {
        User createdUser1 = userDao.create(testUser1);
        System.out.println("----- Created user #1: " + createdUser1);

        User createdUser2 = userDao.create(testUser2);
        System.out.println("----- Created user #2: " + createdUser2);

        assertNotNull(createdUser1);
        assertNotNull(createdUser2);
        assertNotNull(createdUser1.getId());
        assertNotNull(createdUser2.getId());

    }

    @Test
    public void testFindUser() {
        User createdUser1 = userDao.create(testUser1);
        System.out.println("----- Created user #1: " + createdUser1);

        User createdUser2 = userDao.create(testUser2);
        System.out.println("----- Created user #2: " + createdUser2);

        User foundUser1 = userDao.find(createdUser1.getId());
        System.out.println("----- Found user #1: " + foundUser1);

        User foundUser2 = userDao.find(createdUser2.getId());
        System.out.println("----- Found user #2: " + foundUser2);

        assertNotNull(foundUser1);
        assertNotNull(foundUser2);
        assertEquals(createdUser1.getId(), foundUser1.getId());
        assertEquals(createdUser2.getId(), foundUser2.getId());
        assertEquals(createdUser1.getName(), foundUser1.getName());
        assertEquals(createdUser2.getName(), foundUser2.getName());
        assertTrue(!createdUser1.getRoles().isEmpty());
        assertTrue(!createdUser2.getRoles().isEmpty());
        assertEquals(2, createdUser1.getRoles().size());
        assertEquals(1, createdUser2.getRoles().size());
        createdUser1.getRoles().forEach(role -> assertNotNull(role.getId()));
        createdUser1.getRoles().forEach(role -> assertNotNull(role.getId()));
    }

    @Test
    public void testUpdateWithNewAddressUser() {
        User createdUser1 = userDao.create(testUser1);
        System.out.println("----- Created user #1: " + createdUser1);

        User createdUser2 = userDao.create(testUser2);
        System.out.println("----- Created user #2: " + createdUser2);

        Role newRole = new Role("Consumer");
        createdUser1.getRoles().add(newRole);
        newRole.getUsers().add(createdUser1);
        createdUser2.getRoles().add(newRole);
        newRole.getUsers().add(createdUser2);

        User updatedUser1 = userDao.update(createdUser1);
        User updatedUser2 = userDao.update(createdUser2);
        System.out.println("----- Updated user #1: " + updatedUser1);
        System.out.println("----- Updated user #2: " + updatedUser2);

        assertNotNull(updatedUser1);
        assertNotNull(updatedUser2);
        assertEquals(createdUser1.getId(), updatedUser1.getId());
        assertEquals(createdUser2.getId(), updatedUser2.getId());

        assertEquals(3, updatedUser1.getRoles().size());
        assertEquals(2, updatedUser2.getRoles().size());
        assertTrue(updatedUser1.getRoles().stream().anyMatch(role -> role.getName().equals("Consumer")));
        assertTrue(updatedUser2.getRoles().stream().anyMatch(role -> role.getName().equals("Consumer")));
    }

    @Test
    public void testDeleteUser() {
        User createdUser1 = userDao.create(testUser1);
        System.out.println("----- Created user #1: " + createdUser1);

        User createdUser2 = userDao.create(testUser2);
        System.out.println("----- Created user #2: " + createdUser2);

        Long id1 = createdUser1.getId();
        Long id2 = createdUser2.getId();
        userDao.delete(id1);
        userDao.delete(id2);
        User deletedUser1 = userDao.find(id1);
        User deletedUser2 = userDao.find(id2);

        assertNull(deletedUser1);
        assertNull(deletedUser2);
    }

}
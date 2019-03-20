package by.courses.java.simple.dao.impl;

import by.courses.java.simple.dao.UserDao;
import by.courses.java.simple.entity.Item;
import by.courses.java.simple.entity.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OneToManyUserDaoImplTest {

    private UserDao userDao;

    private User testUser;

    @Before
    public void setUp() {
        userDao = new UserDaoImpl();
        Item testItem1 = new Item("item#1");
        System.out.println("----- Test item #1: " + testItem1);
        Item testItem2 = new Item("item#2");
        System.out.println("----- Test item #2: " + testItem2);

        testUser = new User("Bruce");
        testUser.getItems().add(testItem1);
        testUser.getItems().add(testItem2);
        System.out.println("----- Test user: " + testUser);

//        testItem1.setUser(testUser);
//        testItem2.setUser(testUser);
    }

    @Test
    public void testCreateUser() {
        User createdUser = userDao.create(testUser);
        System.out.println("----- Created user: " + createdUser);

        assertNotNull(createdUser);
        assertNotNull(createdUser.getId());
        assertTrue(!createdUser.getItems().isEmpty());
        createdUser.getItems().forEach(item -> assertNotNull(item.getId()));
    }

    @Test
    public void testFindUser() {
        User createdUser = userDao.create(testUser);
        System.out.println("----- Created user: " + createdUser);

        User foundUser = userDao.find(createdUser.getId());
        System.out.println("----- Found user: " + foundUser);

        assertNotNull(foundUser);
        assertEquals(createdUser.getId(), foundUser.getId());
        assertEquals(createdUser.getName(), foundUser.getName());
        assertTrue(!foundUser.getItems().isEmpty());
        assertEquals(2, foundUser.getItems().size());
        foundUser.getItems().forEach(item -> {
            assertNotNull(item.getId());
            assertTrue(item.getName().startsWith("item"));
//            assertEquals(testUser, item.getUser());
        });
    }

    @Test
    public void testUpdateWithNewAddressUser() {
        User createdUser = userDao.create(testUser);
        System.out.println("----- Created user: " + createdUser);

        createdUser.setName("Batman");
        Item newItem = new Item("item#3");
        createdUser.getItems().add(newItem);

        User updatedUser = userDao.update(createdUser);
        System.out.println("----- Updated user: " + updatedUser);

        assertNotNull(updatedUser);
        assertEquals(createdUser.getId(), updatedUser.getId());
        assertEquals(createdUser.getName(), updatedUser.getName());

        assertEquals(3, updatedUser.getItems().size());
        updatedUser.getItems().forEach(item -> {
            assertNotNull(item.getId());
            assertTrue(item.getName().startsWith("item"));
//            assertEquals(testUser, item.getUser());
        });
    }

    @Test
    public void testUpdateAddressUser() {
        User createdUser = userDao.create(testUser);
        System.out.println("----- Created user: " + createdUser);

        createdUser.setName("Batman");
        createdUser.getItems().forEach(item -> item.setName("testItem"));

        User updatedUser = userDao.update(createdUser);
        System.out.println("----- Updated user: " + updatedUser);

        assertNotNull(updatedUser);
        assertEquals(createdUser.getId(), updatedUser.getId());
        assertEquals(createdUser.getName(), updatedUser.getName());

        assertEquals(2, updatedUser.getItems().size());
        updatedUser.getItems().forEach(item -> {
            assertNotNull(item.getId());
            assertTrue(item.getName().startsWith("test"));
//            assertEquals(testUser, item.getUser());
        });
    }

    @Test
    public void testDeleteUser() {
        User createdUser = userDao.create(testUser);
        System.out.println("----- Created user: " + createdUser);

        Long id = createdUser.getId();
        userDao.delete(id);
        User deletedUser = userDao.find(id);

        assertNull(deletedUser);
    }

}
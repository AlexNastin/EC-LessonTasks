package by.courses.java.simple.dao.impl;

import by.courses.java.simple.dao.UserDao;
import by.courses.java.simple.entity.Address;
import by.courses.java.simple.entity.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OneToOneUserDaoImplTest {

    private UserDao userDao;

    private User testUser;

    @Before
    public void setUp() {
        userDao = new UserDaoImpl();
        Address testAddress = new Address("street", "city");
        System.out.println("----- Test address: " + testAddress);

        testUser = new User("Bruce");
        testUser.setAddress(testAddress);
        System.out.println("----- Test user: " + testUser);

//        testAddress.setUser(testUser);
    }

    @Test
    public void testCreateUser() {
        User createdUser = userDao.create(testUser);
        System.out.println("----- Created user: " + createdUser);

        assertNotNull(createdUser);
        assertNotNull(createdUser.getId());
        assertNotNull(createdUser.getAddress());
        assertNotNull(createdUser.getAddress().getId());
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
        assertNotNull(foundUser.getAddress());
        assertEquals(createdUser.getAddress().getId(), foundUser.getAddress().getId());
        assertEquals(createdUser.getAddress().getStreet(), foundUser.getAddress().getStreet());
        assertEquals(createdUser.getAddress().getCity(), foundUser.getAddress().getCity());
//        assertEquals(createdUser.getShippingAddress().getUser(), foundUser.getShippingAddress().getUser());
    }

    @Test
    public void testUpdateWithNewAddressUser() {
        User createdUser = userDao.create(testUser);
        System.out.println("----- Created user: " + createdUser);

        createdUser.setName("Batman");
        Address newAddress = new Address("otherStreet", "otherCity");
        createdUser.setAddress(newAddress);

        User updatedUser = userDao.update(createdUser);
        System.out.println("----- Updated user: " + updatedUser);

        assertNotNull(updatedUser);
        assertEquals(createdUser.getId(), updatedUser.getId());
        assertEquals(createdUser.getName(), updatedUser.getName());

        assertNotNull(updatedUser.getAddress().getId());
        assertEquals(updatedUser.getAddress().getCity(), newAddress.getCity());
        assertEquals(updatedUser.getAddress().getStreet(), newAddress.getStreet());
    }

    @Test
    public void testUpdateAddressUser() {
        User createdUser = userDao.create(testUser);
        System.out.println("----- Created user: " + createdUser);

        createdUser.setName("Batman");
        createdUser.getAddress().setCity("otherCity");
        createdUser.getAddress().setStreet("otherStreet");

        User updatedUser = userDao.update(createdUser);
        System.out.println("----- Updated user: " + updatedUser);

        assertNotNull(updatedUser);
        assertEquals(createdUser.getId(), updatedUser.getId());
        assertEquals(createdUser.getName(), updatedUser.getName());

        assertNotNull(updatedUser.getAddress().getId());
        assertEquals(updatedUser.getAddress().getCity(), createdUser.getAddress().getCity());
        assertEquals(updatedUser.getAddress().getStreet(), createdUser.getAddress().getStreet());
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
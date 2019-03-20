package by.courses.java.simple.dao.impl;

import by.courses.java.simple.entity.User;
import by.courses.java.simple.dao.UserDao;
import by.courses.java.utils.PostgreSQLDatabaseManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDaoImpl implements UserDao {

    private EntityManager entityManager = PostgreSQLDatabaseManager.getInstance().getEntityManager();

    public UserDaoImpl() {
    }

    @Override
    public User create(User user) {
        EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.persist(user);
            tx.commit();
        return user;
    }

    @Override
    public User find(Long id) {
        EntityTransaction tx = entityManager.getTransaction();
        User foundUser;
            tx.begin();
            foundUser = entityManager.find(User.class, id); //you don't care DB contains it or not
//            foundUser = entityManager.getReference(User.class, id); //in orger to update (then you exactly need this entity)
            tx.commit();
        return foundUser;
    }

    @Override
    public List<User> findAll() {
        EntityTransaction tx = entityManager.getTransaction();
        List<User> users;
            tx.begin();
            users = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
            tx.commit();
        return users;
    }

    @Override
    public User update(User user) {
        EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(user);
            tx.commit();
        return user;
    }

    @Override
    public void delete(Long id) {
        EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            User user = entityManager.getReference(User.class, id);
            entityManager.remove(user);
            tx.commit();
    }
}

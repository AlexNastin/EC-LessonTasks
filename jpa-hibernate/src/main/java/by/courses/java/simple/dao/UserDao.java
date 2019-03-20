package by.courses.java.simple.dao;

import by.courses.java.simple.entity.User;

import java.util.List;

public interface UserDao {

    User create(User user);

    User find(Long id);

    List<User> findAll();

    User update(User user);

    void delete(Long id);

}

package by.courses.java.service;

import by.courses.java.entity.User;

import java.util.List;

public interface UserService {

     User findUser(Long id);

     User save(User user);

     void delete(User user);

     List<User> findUsers();
}

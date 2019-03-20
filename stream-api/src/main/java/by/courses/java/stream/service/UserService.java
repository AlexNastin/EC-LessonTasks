package by.courses.java.stream.service;

import by.courses.java.stream.entity.User;

import java.util.List;
import java.util.function.Predicate;

public interface UserService {
    List<User> getUsersByName(String name, List<User> users);

    List<User> getUsersByNameAndAge(String name, int age, List<User> users);

    List<User> getUsersByPredicate(Predicate<User> userPredicate, List<User> users);
}

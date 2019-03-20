package by.courses.java.stream.service.impl;

import by.courses.java.stream.entity.User;
import by.courses.java.stream.service.UserService;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    @Override
    public List<User> getUsersByName(String name, List<User> users) {
        return users.stream().filter(user -> user.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public List<User> getUsersByNameAndAge(String name, int age, List<User> users) {
        return users.stream().filter(user -> user.getName().equals(name) && user.getAge() == age).collect(Collectors.toList());
    }

    @Override
    public List<User> getUsersByPredicate(Predicate<User> userPredicate, List<User> users) {
        return users.stream().filter(userPredicate).collect(Collectors.toList());
    }
}

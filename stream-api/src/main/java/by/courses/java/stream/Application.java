package by.courses.java.stream;

import by.courses.java.stream.entity.User;
import by.courses.java.stream.service.UserService;
import by.courses.java.stream.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Application {

    private static UserService userService = new UserServiceImpl();
    private static final String NAME = "Andrey";
    private static final int AGE = 21;

    public static void main(String[] args) {
        final Predicate<User> userNamePredicate = user -> user.getName().equals(NAME);
        final List<User> users = new ArrayList<>();
        final List<User> usersByName = userService.getUsersByName(NAME, users);
        final List<User> usersByNameAndAge = userService.getUsersByNameAndAge(NAME, AGE, users);
        final List<User> usersByPredicate = userService.getUsersByPredicate(userNamePredicate, users);
        System.out.println("DONE");
    }


}

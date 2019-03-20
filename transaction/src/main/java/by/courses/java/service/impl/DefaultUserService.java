package by.courses.java.service.impl;

import by.courses.java.dao.UserRepository;
import by.courses.java.entity.User;
import by.courses.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public User findUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Transactional(readOnly = true)
    public List<User> findUsers() {
        return userRepository.findAll();
    }
}
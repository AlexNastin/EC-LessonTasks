package com.example.springdata.service;

import com.example.springdata.dao.UserRepository;
import com.example.springdata.entity.User;
import com.example.springdata.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User findUser(Integer id) throws NotFoundException {
        if (id.equals(1)) {
            Optional<User> user = userRepository.findById(id);
            return user.get();
        } else {
            throw new NotFoundException("User with id: " + id + " was not found");
        }

    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }
}

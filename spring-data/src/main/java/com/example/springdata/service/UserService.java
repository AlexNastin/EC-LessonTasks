package com.example.springdata.service;

import com.example.springdata.dao.UserRepository;
import com.example.springdata.entity.User;
import com.example.springdata.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUser(Integer id) throws NotFoundException {
        if (id.equals(1)) {
            return userRepository.findOne(id);
        } else {
            throw new NotFoundException("User with id: " + id  + " was not found");
        }

    }

}

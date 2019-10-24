package com.nastsin.ec.springweb.service;

import com.nastsin.ec.springweb.entity.User;
import com.nastsin.ec.springweb.exception.NotFoundException;

import java.util.List;

public interface UserService {

    User getUser(Long id) throws NotFoundException;

    User saveUser(User user);

    List<User> getUsers();

    void deleteUser(Long id);
}

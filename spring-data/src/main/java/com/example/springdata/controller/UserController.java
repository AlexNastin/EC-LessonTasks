package com.example.springdata.controller;

import com.example.springdata.entity.ErrorMessage;
import com.example.springdata.entity.User;
import com.example.springdata.exception.NotFoundException;
import com.example.springdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<User> findUser(@PathVariable("userId") Integer id) throws NotFoundException {
        User user = userService.findUser(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


}

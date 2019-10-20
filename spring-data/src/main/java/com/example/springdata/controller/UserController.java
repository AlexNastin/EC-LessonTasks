package com.example.springdata.controller;

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

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> findUser(@PathVariable("userId") Integer id) throws NotFoundException {
        User user = userService.findUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/test-save")
    public ResponseEntity<User> findUser(@RequestBody User user) throws NotFoundException {
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

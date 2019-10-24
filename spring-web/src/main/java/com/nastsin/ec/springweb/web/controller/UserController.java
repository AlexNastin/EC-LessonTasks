package com.nastsin.ec.springweb.web.controller;

import com.nastsin.ec.springweb.dto.UserDto;
import com.nastsin.ec.springweb.entity.User;
import com.nastsin.ec.springweb.service.DefaultUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final DefaultUserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(DefaultUserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findUser(@PathVariable("id") Long id) {
        User user = userService.getUser(id);
        System.out.println(user);
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
        return null;
    }
}

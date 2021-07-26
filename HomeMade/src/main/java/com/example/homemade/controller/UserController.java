package com.example.homemade.controller;

import com.example.homemade.controller.model.UserRequest;
import com.example.homemade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody UserRequest request) {
        userService.register(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}

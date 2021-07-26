package com.example.homemade.service;

import com.example.homemade.controller.model.UserRequest;
import com.example.homemade.persistence.models.Role;
import com.example.homemade.persistence.models.User;
import com.example.homemade.persistence.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    public final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;


    public UserService(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }

    public User register(UserRequest request){
        User user = convertFromRequestToUser(request);
        return userRepository.save(user);
    }

    public User findByUsername(String userName){
        return userRepository.findUserByUsername(userName);
    }

    private User convertFromRequestToUser(UserRequest request){
        User user = new User();
        user.setFullname(request.getFullname());
        user.setUsername(request.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        return user;

    }



}

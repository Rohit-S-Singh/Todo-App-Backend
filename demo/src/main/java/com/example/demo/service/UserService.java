package com.example.demo.service;

import com.example.demo.entity.User;

import org.springframework.beans.factory.annotation.Autowired;


import com.example.demo.repository.UserEntry;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private UserEntry newUser;

    public void saveUser(User user){
        newUser.insert(user);
    }
}

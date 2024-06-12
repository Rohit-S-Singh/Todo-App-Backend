package com.example.demo.controllers;


import com.example.demo.entity.User;
import com.example.demo.service.TodoService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService newUserEntry;


    @PostMapping("/add-user")
    public ResponseEntity<Map<String,String>> addUser(@RequestBody User user){

        Map<String,String> mp = new HashMap<>();

        mp.put("Status","200");
        mp.put("Message","User is successfully added");

        newUserEntry.saveUser(user);

        System.out.println("user found is this---->>"+user);

        return new ResponseEntity<>(mp, HttpStatus.OK);
    }
}

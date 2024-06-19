package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserEntry extends MongoRepository<User,String> {

}

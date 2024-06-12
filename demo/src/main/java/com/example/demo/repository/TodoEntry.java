package com.example.demo.repository;

import com.example.demo.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoEntry extends MongoRepository<Task, String> {

}
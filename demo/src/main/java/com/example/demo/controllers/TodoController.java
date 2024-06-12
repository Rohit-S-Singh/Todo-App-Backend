package com.example.demo.controllers;

import com.example.demo.entity.Task;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService newtodoservice;

    private Map<String, Task> taskMap = new HashMap<>();
    private AtomicLong counter = new AtomicLong();


    @GetMapping("/health-check")
    public String a(){
        return "OK";
    }

    @PostMapping("/addTask")
    public ResponseEntity<Map<String, String>> addTask(@RequestBody Task task) {

        newtodoservice.saveTask(task);

        System.out.println("abcd is getting added---------------"+task);

        Map<String,String> hs = new HashMap();

        hs.put("status","200");
        hs.put("message","Task is successfully addded");

        return new ResponseEntity<>(hs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskMap.get(id);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        if (taskMap.remove(id) != null) {
            return "Task deleted successfully.";
        } else {
            return "Task not found.";
        }
    }

    @PutMapping("/{id}")
    public String updateTask(@PathVariable String id, @RequestBody Task updatedTask) {
        if (taskMap.containsKey(id)) {
            updatedTask.setId(id);
            taskMap.put(id, updatedTask);
            return "Task updated successfully.";
        } else {
            return "Task not found.";
        }
    }

}

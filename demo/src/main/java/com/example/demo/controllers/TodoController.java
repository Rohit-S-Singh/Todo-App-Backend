package com.example.demo.controllers;


import com.example.demo.entity.Task;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/todos")
public class TodoController {


    private Map<Long, Task> taskMap = new HashMap<>();
    private AtomicLong counter = new AtomicLong();


    @GetMapping("/health-check")
    public String a(){
        return "OK";
    }

    @PostMapping("/addTask")
    public String addTask(@RequestBody Task task) {

        System.out.println("abcd is getting added---------------");

        long id = counter.incrementAndGet();
        task.setId(id);
        taskMap.put(id, task);
        return "Task added successfully with ID: " + id;
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
    public String updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        if (taskMap.containsKey(id)) {
            updatedTask.setId(id);
            taskMap.put(id, updatedTask);
            return "Task updated successfully.";
        } else {
            return "Task not found.";
        }
    }

    @GetMapping("/all")
    public Map<Long, Task> getAllTasks() {
        return taskMap;
    }






}

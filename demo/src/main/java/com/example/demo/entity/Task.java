package com.example.demo.entity;

import java.util.HashMap;
import java.time.LocalDate;

public class Task {
    private Long id;
    private String name;
    private String description;
    private LocalDate dueDate;

    // Constructors, Getters and Setters
    public Task() {
    }

    public Task(Long id, String name, String description, LocalDate dueDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}

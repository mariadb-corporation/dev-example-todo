package com.mariadb.todo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

// Lombok annotation that eliminates getter/setter boilerplate code
@Data 
@RequiredArgsConstructor
@Table("tasks")
public class Task {
    @Id private Integer id;
    private String description;
    private Boolean completed;
}
package com.mariadb.todo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

//import lombok.AllArgsConstructor;
import lombok.Data;

// Lombok annotation that eliminates getter/setter boilerplate code
@Data 
//@AllArgsConstructor
// Annotation that will point to table "tasks" (pluralized in the database)
@Table("tasks")
public class Task {
    @Id private Integer id;
    private String description;
    private Boolean completed;
}
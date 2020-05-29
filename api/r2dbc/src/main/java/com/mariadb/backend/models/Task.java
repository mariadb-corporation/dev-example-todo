package com.mariadb.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Table("tasks")
public class Task {
    @Id private Integer id;
    private String description;
    private Boolean completed;
}
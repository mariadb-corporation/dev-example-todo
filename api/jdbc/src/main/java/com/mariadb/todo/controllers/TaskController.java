package com.mariadb.todo.controllers;

import com.mariadb.todo.domain.Task;
import com.mariadb.todo.services.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    // Get all tasks
    @GetMapping()
    public ResponseEntity<Iterable<Task>> get() {
        return ResponseEntity.ok(this.service.getAllTasks());
    }

    // Create a new task
    @PostMapping()
    public ResponseEntity<Task> post(@RequestBody Task task) {
        if (service.isValid(task)) {
            return ResponseEntity.ok(this.service.createTask(task));
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    // Update a task
    @PutMapping()
    public ResponseEntity<Task> put(@RequestBody Task task) {
        if (service.isValid(task)) {
            return ResponseEntity.ok(this.service.updateTask(task));
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    // Delete a task
    @DeleteMapping()
    public ResponseEntity<Void> delete(@RequestParam int id) {
        if (id > 0) {
            this.service.deleteTask(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }
}
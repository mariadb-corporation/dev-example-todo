package com.mariadb.todo;

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

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor // Creates a constructor that accepts references to the final properties of this class
public class TasksController {

    private final TaskService service;

    @GetMapping
    public ResponseEntity<Flux<Task>> get() {
        return ResponseEntity.ok(this.service.getAllTasks());
    }

    @PostMapping
    public ResponseEntity<Mono<Task>> post(@RequestBody Task task) {
        if (service.isValid(task)) {
            return ResponseEntity.ok(this.service.createTask(task));
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    @PutMapping
    public ResponseEntity<Mono<Task>> put(@RequestBody Task task) {
        if (service.isValid(task)) {
            return ResponseEntity.ok(this.service.updateTask(task));
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    @DeleteMapping
    public ResponseEntity<Mono<Void>> delete(@RequestParam int id) {
        if (id > 0) {
            return ResponseEntity.ok(this.service.deleteTask(id));
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }
}
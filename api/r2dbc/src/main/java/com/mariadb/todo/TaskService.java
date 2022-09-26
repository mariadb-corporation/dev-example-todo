package com.mariadb.todo;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// Registered as a Spring Service (Component)
@Service
@RequiredArgsConstructor // Creates a constructor that accepts references to the final properties of this class
public class TaskService {
    
    // Automatically instantiated (via Spring IoC) 
    private final TasksRepository repository;

    // 
    public Boolean isValid(final Task task) {
        return task != null && !task.getDescription().isEmpty();
    }

    // Get all records from the tasks table
    public Flux<Task> getAllTasks() {
        return this.repository.findAll();
    }

    // Save a new task record
    public Mono<Task> createTask(final Task task) {
        return this.repository.save(task);
    }

    // Update an existing task record
    public Mono<Task> updateTask(final Task task) {
        return this.repository.findById(task.getId())
                .flatMap(t -> {
                    t.setDescription(task.getDescription());
                    t.setCompleted(task.getCompleted());
                    return this.repository.save(t);
                });
    }

    // Delete the task record by specified id
    public Mono<Void> deleteTask(final int id){
        return this.repository.findById(id)
                .flatMap(this.repository::delete);
    }
}
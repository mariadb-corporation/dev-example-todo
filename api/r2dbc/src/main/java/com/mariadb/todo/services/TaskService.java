package com.mariadb.todo.services;

import com.mariadb.todo.models.Task;
import com.mariadb.todo.repositories.TasksRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// Registered as a Spring Service (Component)
@Service
public class TaskService {
    
    // Automatically instantiate (via Spring IoC) 
    @Autowired
    private TasksRepository repository;

    // 
    public Boolean isValid(final Task task) {
        if (task != null && !task.getDescription().isEmpty()) {
            return true;
        }
        return false;
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
    @Transactional
    public Mono<Task> updateTask(final Task task) {
        return this.repository.findById(task.getId())
                .flatMap(t -> {
                    t.setDescription(task.getDescription());
                    t.setCompleted(task.getCompleted());
                    return this.repository.save(t);
                });
    }

    // Delete the task record by specified id
    @Transactional
    public Mono<Void> deleteTask(final int id){
        return this.repository.findById(id)
                .flatMap(this.repository::delete);
    }
}
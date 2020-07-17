package com.mariadb.todo.services;

import java.util.Optional;

import com.mariadb.todo.domain.Task;
import com.mariadb.todo.repositories.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Registered as a Spring Service (Component)
@Service
public class TaskService {
    
    // Automatically instantiate (via Spring IoC) 
    @Autowired
    private TaskRepository repository;

    // 
    public Boolean isValid(final Task task) {
        if (task != null && !task.getDescription().isEmpty()) {
            return true;
        }
        return false;
    }

    // Get all records from the tasks table
    public Iterable<Task> getAllTasks() {
        return this.repository.findAll();
    }

    // Save a new task record
    public Task createTask(final Task task) {
        return this.repository.save(task);
    }

    // Update an existing task record
    @Transactional
    public Task updateTask(final Task task) {
        Optional<Task> ot = this.repository.findById(task.getId());
        Task t = ot.get();
        t.setDescription(task.getDescription());
        t.setCompleted(task.getCompleted());
        return this.repository.save(t);
    }

    // Delete the task record by specified id
    @Transactional
    public void deleteTask(final int id){
        Optional<Task> ot = this.repository.findById(id);
        Task t = ot.get();
        this.repository.delete(t);
    }
}
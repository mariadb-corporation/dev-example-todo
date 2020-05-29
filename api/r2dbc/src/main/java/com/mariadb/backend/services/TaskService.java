package com.mariadb.backend.services;

import com.mariadb.backend.models.Task;
import com.mariadb.backend.repositories.TasksRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TaskService {
    
    @Autowired
    private TasksRepository repository;

    public Boolean isValid(final Task task) {
        if (task != null && !task.getDescription().isEmpty()) {
            return true;
        }
        return false;
    }

    public Flux<Task> getAllTasks() {
        return this.repository.findAll();
    }

    public Mono<Task> createTask(final Task task) {
        return this.repository.save(task);
    }

    @Transactional
    public Mono<Task> updateTask(final Task task) {
        return this.repository.findById(task.getId())
                .flatMap(t -> {
                    t.setDescription(task.getDescription());
                    t.setCompleted(task.getCompleted());
                    return this.repository.save(t);
                });
    }

    @Transactional
    public Mono<Void> deleteTask(final int id){
        return this.repository.findById(id)
                .flatMap(this.repository::delete);
    }
}
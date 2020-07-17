package com.mariadb.todo.repositories;

import com.mariadb.todo.models.Task;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

// Registered as a Spring Repository (Component)
// Repository = a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects
public interface TasksRepository extends ReactiveCrudRepository<Task, Integer> {
}
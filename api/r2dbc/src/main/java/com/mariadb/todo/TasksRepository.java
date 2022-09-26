package com.mariadb.todo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

// Registered as a Spring Repository (Component)
// Repository = a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects
public interface TasksRepository extends R2dbcRepository<Task, Integer> {
}
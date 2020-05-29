package com.mariadb.backend.repositories;

import com.mariadb.backend.models.Task;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends ReactiveCrudRepository<Task, Integer> {
}
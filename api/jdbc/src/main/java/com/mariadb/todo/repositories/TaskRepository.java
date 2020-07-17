package com.mariadb.todo.repositories;

import com.mariadb.todo.domain.Task;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {
}

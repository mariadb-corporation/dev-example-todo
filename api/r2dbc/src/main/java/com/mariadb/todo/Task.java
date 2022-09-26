package com.mariadb.todo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data // Lombok annotation that eliminates getter/setter boilerplate code
@Table("tasks")
public class Task {

	@Id
	private Integer id;
	private String description;
	private Boolean completed;

}
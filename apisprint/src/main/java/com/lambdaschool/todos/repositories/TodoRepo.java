package com.lambdaschool.todos.repositories;

import com.lambdaschool.todos.models.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<Todo, Long> {
}

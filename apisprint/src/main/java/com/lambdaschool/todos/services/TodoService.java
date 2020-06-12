package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;

public interface TodoService {
	Todo findTodoById(long todoid);

	Todo save(long userid, Todo todo);

	Todo update(long todoid);
}

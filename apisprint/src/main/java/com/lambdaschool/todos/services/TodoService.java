package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;

public interface TodoService {
	Todo save(long userid, Todo todo);
}

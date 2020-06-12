package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.repositories.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "todoService")
public class TodoServiceImpl implements TodoService {
	@Autowired
	private TodoRepo todorepo;

	@Autowired
	private UserService userService;

	@Transactional
	@Override
	public Todo save(long userid, Todo todo) {
		User currentUser = userService.findUserById(userid);
		Todo newTodo = new Todo(currentUser, todo.getDescription());

		return todorepo.save(newTodo);
	}
}

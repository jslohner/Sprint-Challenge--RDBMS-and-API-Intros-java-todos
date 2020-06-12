package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.repositories.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todoService")
public class TodoServiceImpl implements TodoService {
	@Autowired
	private TodoRepo todorepo;

	@Autowired
	private UserService userService;

	@Override
	public Todo findTodoById(long todoid) {
		return todorepo
			.findById(todoid)
			.orElseThrow(() -> new EntityNotFoundException("Todo " + todoid + " Not Found"));
	}

	@Transactional
	@Override
	public Todo save(long userid, Todo todo) {
		User currentUser = userService.findUserById(userid);
		Todo newTodo = new Todo(currentUser, todo.getDescription());

		return todorepo.save(newTodo);
	}

	@Transactional
	@Override
	public Todo update(long todoid) {
		if (todorepo.findById(todoid).isPresent()) {
			Todo currentTodo = findTodoById(todoid);
			currentTodo.setCompleted(!currentTodo.isCompleted());
			return todorepo.save(currentTodo);
		} else {
			throw new EntityNotFoundException("Todo " + todoid + " Not Found");
		}
	}
}

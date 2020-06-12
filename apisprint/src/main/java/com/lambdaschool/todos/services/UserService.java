package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.views.UserCountTodos;

import java.util.List;

public interface UserService {
	List<User> findAllUsers();

	User findUserById(long id);

	User save(User user);

	void delete(long userid);

	List<UserCountTodos> getCountUserTodos();
}

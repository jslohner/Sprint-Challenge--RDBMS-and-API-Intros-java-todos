package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userrepo;

	@Override
	public List<User> findAllUsers() {
		List<User> allUsers = new ArrayList<>();

		userrepo
			.findAll()
			.iterator()
			.forEachRemaining(allUsers::add);
		return allUsers;
	}

	@Transactional
	@Override
	public User save(User user) {
		User newUser = new User();

		newUser.setUsername(user.getUsername().toLowerCase());
		newUser.setPrimaryemail(user.getPrimaryemail());
		newUser.setPassword(user.getPassword());

		newUser.getTodos().clear();
		for (Todo t : user.getTodos()) {
			newUser.getTodos().add(new Todo(newUser, t.getDescription()));
		}

		return userrepo.save(newUser);
	}
}

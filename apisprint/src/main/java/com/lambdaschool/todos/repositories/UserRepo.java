package com.lambdaschool.todos.repositories;

import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.views.UserCountTodos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {
	@Query(
		value = "SELECT u.username as usernamept, COUNT(t.todoid) as counttodos FROM users u JOIN todos t ON u.userid = t.userid WHERE t.completed = false GROUP BY u.username",
		nativeQuery = true
	)
	List<UserCountTodos> getCountUserTodos();
}
package com.lambdaschool.todos.controllers;

import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping(value = "/users", produces = {"application/json"})
	public ResponseEntity<?> getAllUsers() {
		List<User> allUsers = userService.findAllUsers();
		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}

	@GetMapping(value = "/user/{userid}", produces = {"application/json"})
	public ResponseEntity<?> getUserById(@PathVariable long userid) {
		User user = userService.findUserById(userid);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}

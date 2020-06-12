package com.lambdaschool.todos.controllers;

import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
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

	@PostMapping(value = "/user", consumes = {"application/json"})
	public ResponseEntity<?> addNewUser(@Valid @RequestBody User newuser) throws URISyntaxException {
		newuser.setUserid(0);
		newuser = userService.save(newuser);

		HttpHeaders responseHeaders = new HttpHeaders();
		URI newUserURI = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{userid}")
			.buildAndExpand(newuser.getUserid())
			.toUri();
		responseHeaders.setLocation(newUserURI);

		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}
}

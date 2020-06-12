package com.lambdaschool.todos.controllers;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/todos")
public class TodoController {
	@Autowired
	private TodoService todoService;

	@PostMapping(value = "/user/{userid}", consumes = {"application/json"})
	public ResponseEntity<?> addNewTodo(@Valid @RequestBody Todo newtodo, @PathVariable long userid) throws URISyntaxException {
		newtodo = todoService.save(userid, newtodo);

		HttpHeaders responseHeaders = new HttpHeaders();
		URI newTodoURI = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.replacePath("/todos/todo/{todoid}")
			.build(newtodo.getTodoid());
		responseHeaders.setLocation(newTodoURI);

		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}

	@PatchMapping(value = "/todo/{todoid}")
	public ResponseEntity<?> toggleTodoCompleted(@PathVariable long todoid) {
		todoService.update(todoid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

package com.lambdaschool.todos.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "todoService")
public class TodoServiceImpl implements TodoService {
}

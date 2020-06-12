package com.lambdaschool.todos.repositories;

import com.lambdaschool.todos.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
}

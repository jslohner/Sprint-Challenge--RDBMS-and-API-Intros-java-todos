package com.lambdaschool.todos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JavaSprintApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSprintApplication.class, args);
	}

}

package com.lambdaschool.apisprint.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todo extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long todoid;

	@Column(nullable = false)
	private String description;

	private boolean completed = false;

	@ManyToOne
	@JoinColumn(name = "userid", nullable = false)
	@JsonIgnoreProperties(value = "todos", allowSetters = true)
	private User user;

	public Todo() {
	}

	public Todo(String description, boolean completed, User user) {
		this.description = description;
		this.completed = completed;
		this.user = user;
	}

	public long getTodoid() {
		return todoid;
	}

	public void setTodoid(long todoid) {
		this.todoid = todoid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}

// completed boolean. Note that for all new todos, default completed to false
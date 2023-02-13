package com.kerem.restfulwebservices.todoapp.todo;

import java.time.LocalDate;
import java.util.Date;

public class Todo {
	
	private int id;
	private String username;
	private String description;
	private boolean isDone;
	private LocalDate targetDate;
	
	public Todo() {
		
	}

	public Todo(int id, String username, String description, boolean isDone, LocalDate targetDate) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.isDone = isDone;
		this.targetDate = targetDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", isDone=" + isDone
				+ ", targetDate=" + targetDate + "]";
	}
	
}

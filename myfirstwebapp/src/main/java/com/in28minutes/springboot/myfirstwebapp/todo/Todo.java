package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

//Database (MySQL)
//Static List of Todos => Database (H2, MySQL)

//JPA
//Bean => Database Table

@Entity
public class Todo {

	@Id
	@GeneratedValue
	private int id;
	private String userName;
	
	@Size(min = 10, message = "Enter atleast 10 characters")
	private String description;
	private LocalDate targetDate;
	private boolean done;
	
	public Todo() {
		
	}

	public Todo(int id, String userName, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.userName = userName;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean getDone() {
		return done;
	}

	public void setDone(boolean isDone) {
		this.done = isDone;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", userName=" + userName + ", description=" + description + ", targetDate="
				+ targetDate + ", isDone=" + done + "]";
	}
	

}

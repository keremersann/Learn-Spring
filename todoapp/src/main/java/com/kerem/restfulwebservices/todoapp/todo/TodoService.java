package com.kerem.restfulwebservices.todoapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>(); 
	private static int count = 0;
	
	static {
		todos.add(new Todo(++count,"kerem", "Learn Dancing", false, LocalDate.now().plusYears(3)));
		todos.add(new Todo(++count,"kerem", "Learn Singing", false, LocalDate.now().plusYears(2)));
		todos.add(new Todo(++count,"kerem", "Learn Programming", false, LocalDate.now().plusYears(1)));
	}
	
	public Todo add(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++count, username, description, done, targetDate);
		todos.add(todo);
		return todo;
	}
	
	public List<Todo> findTodosByUsername(String username){
		Predicate<? super Todo> predicate = 
				todo -> todo.getUsername().equals(username);
		
		return todos.stream().filter(predicate).toList();
	}
	
	public void deleteTodo(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	
	public void updateTodo(Todo todo) {
		deleteTodo(todo.getId());
		todos.add(todo);
	}
}

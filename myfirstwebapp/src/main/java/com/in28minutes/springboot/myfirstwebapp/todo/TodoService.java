package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	
	private static int count = 0;
	
	static {
		todos.add(new Todo(++count, "kerem", "Learn Aws Certified", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++count, "kerem", "Learn DevOps", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++count, "kerem", "Learn Full Stack Development", LocalDate.now().plusYears(3), false));
	}
	
	public void add(String username, String description, LocalDate targetDate, boolean done) {
		todos.add(new Todo(++count, username, description, targetDate, done));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate = 
				todo -> todo.getUserName().equals(username);
		
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

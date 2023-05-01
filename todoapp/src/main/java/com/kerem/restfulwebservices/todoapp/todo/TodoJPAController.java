package com.kerem.restfulwebservices.todoapp.todo;

import com.kerem.restfulwebservices.todoapp.repository.TodoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoJPAController {
	private TodoRepository todoRepository;
	private TodoService todoService;

	public TodoJPAController(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	@GetMapping("/users/{username}/todos")
	public List<Todo> ListAllTodos(@PathVariable String username) {
		return todoRepository.findByUsername(username);
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todo ListTodoById(@PathVariable String username,@PathVariable int id) {
		return todoRepository.findById(id).get();
	}
	
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodoById(@PathVariable String username,@PathVariable int id){
		todoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/users/{username}/todos/{id}")
	public Todo updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo) {
		todoRepository.save(todo);
		return todo;
	}
	
	@PostMapping("/users/{username}/todos")
	public Todo updateTodo(@PathVariable String username, @RequestBody Todo todo) {
		return todoRepository.save(todo);
	}
}

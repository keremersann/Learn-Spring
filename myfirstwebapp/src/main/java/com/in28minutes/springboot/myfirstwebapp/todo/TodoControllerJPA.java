package com.in28minutes.springboot.myfirstwebapp.todo;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJPA {
	
	private TodoRepository todoRepository;
	
	public TodoControllerJPA(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	@RequestMapping(value = "list-todos", method = RequestMethod.GET)
	public String ListAllTodos(ModelMap model) {
		String username = getLoggedinUsername();
		List<Todo> todos = todoRepository.findByUserName(username);
		model.put("todos", todos);
		return "listTodos";
	}
	
	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		Todo todo = new Todo(0, "kerem" ,"", null, false);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult results) {
		
		if(results.hasErrors()) {
			return "todo";
		}
		
		String username = getLoggedinUsername();
		todo.setUserName(username);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(ModelMap model, @RequestParam int id) {
		Todo todo = todoRepository.findById(id).get();
		model.put("todo", todo);
		return "todo";
	}
	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodoDetails(ModelMap model, @Valid Todo todo, BindingResult results) {
		String username = getLoggedinUsername();
		todo.setUserName(username);
		
		if(results.hasErrors()) {
			return "todo";
		}
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	
	public String getLoggedinUsername() {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		
		return authentication.getName();
	}

}

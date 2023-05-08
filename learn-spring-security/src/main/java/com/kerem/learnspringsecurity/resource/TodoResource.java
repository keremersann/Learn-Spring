package com.kerem.learnspringsecurity.resource;

import jakarta.annotation.security.RolesAllowed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableMethodSecurity
public class TodoResource {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private final List<Todo> todoList = List.of(new Todo("kerem", "Learn Dance")
    ,new Todo("kerem", "Learn Swim"));

    @GetMapping(path = "/todos")
    public List<Todo> retrieveAllTodos(){
        return todoList;
    }
    @GetMapping(path = "/users/{username}/todos")
    @PreAuthorize("hasRole('USER') and #username == authentication.name")
    @PostAuthorize("returnObject.username == 'kerem'")
    @RolesAllowed({"USER","ADMIN"})
    public Todo retrieveAllTodosByUsername(@PathVariable String username){
        return todoList.get(0);
    }
    @PostMapping(path = "/users/{username}/todos")
    public void createTodo(@PathVariable String username, @RequestBody Todo todo){
        logger.info("Create {} for {}", todo, username);
    }
}

record Todo(String username, String todoName){}

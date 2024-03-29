package com.kerem.restfulwebservices.todoapp.repository;

import com.kerem.restfulwebservices.todoapp.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

     List<Todo> findByUsername(String username);
}

package com.kerem.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	
	private UserDaoService userDaoService;
	
	public UserResource(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}
	
	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		return userDaoService.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		User user = userDaoService.findById(id);
		
		if(user == null) 
			throw new UserNotFoundException("id: " + id);
		EntityModel<User> entityModel = EntityModel.of(user);
		
		WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(linkBuilder.withRel("all-users"));
		return entityModel;
	}
	
	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userDaoService.deleteById(id);
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
		userDaoService.save(user);
		
		// users/4 => /users, user.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					   .path("/{id}")
					   .buildAndExpand(user.getId())
					   .toUri();
		
		return ResponseEntity.created(location).build();
	}

}

package com.kerem.rest.webservices.restfulwebservices.jpa;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

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

import com.kerem.rest.webservices.restfulwebservices.user.Post;
import com.kerem.rest.webservices.restfulwebservices.user.User;
import com.kerem.rest.webservices.restfulwebservices.user.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {

	private UserRepository userRepository;
	private PostRepository postRepository;

	public UserJpaResource(UserRepository userRepository, PostRepository postRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}

	@GetMapping(path = "/jpa/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping(path = "/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		User user = userRepository.findById(id).get();

		if (user == null)
			throw new UserNotFoundException("id: " + id);
		EntityModel<User> entityModel = EntityModel.of(user);

		WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(linkBuilder.withRel("all-users"));
		return entityModel;
	}

	@DeleteMapping(path = "/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}

	@GetMapping(path = "/jpa/users/{id}/posts")
	public List<Post> retrievePostsByUser(@PathVariable int id) {
		User user = userRepository.findById(id).get();

		if (user == null)
			throw new UserNotFoundException("id: " + id);

		return user.getPosts();
	}

	@PostMapping(path = "/jpa/users")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
		userRepository.save(user);

		// users/4 => /users, user.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PostMapping(path = "/jpa/users/{id}/posts")
	public ResponseEntity<Object> savePost(@PathVariable int id, @Valid @RequestBody Post post) {
		User user = userRepository.findById(id).get();

		if (user == null)
			throw new UserNotFoundException("id: " + id);

		post.setUser(user);
		Post savedPost = postRepository.save(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@GetMapping(path = "jpa/users/{id}/posts/{postId}")
	public Post retrievePostByUser(@PathVariable int postId) {
		Post post = postRepository.findById(postId).get();
		if (post == null)
			throw new UserNotFoundException("id: " + postId);

		return post;
	}
}

package com.mahendra.restful.webservice.restfulwebservice.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mahendra.restful.webservice.restfulwebservice.entities.User;
import com.mahendra.restful.webservice.restfulwebservice.exception.UserNotFoundException;
import com.mahendra.restful.webservice.restfulwebservice.service.UserService;

@RestController
@RequestMapping("api/v1")
public class UserController {

	@Autowired
	private UserService userService;

	// retrieve All Users
	// Method = GET
	// URI = /users
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userService.findAll();
	}

	// retrieve User by Id

	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = userService.findById(id).get();
		if (user == null) {
			throw new UserNotFoundException("id -  " + id);
		}
		return user;
	}

	// input - details of user
	// output - Created & Return the Created URI
	// @RequestBody = whatever we pass in body of request will be mapped to User
	// argument
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User createUser = userService.save(user);

		// Return Created User URI e.g. users/6
		// It Will return the status code of 201 created
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createUser.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}

	// Delete User By Id

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteById(id);
		
		
	}

}

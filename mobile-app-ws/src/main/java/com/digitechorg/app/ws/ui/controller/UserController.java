package com.digitechorg.app.ws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitechorg.app.ws.ui.model.reponse.UserRest;
import com.digitechorg.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.digitechorg.app.ws.ui.model.request.UserDetailsRequestModel;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

	Map<String, UserRest> users;

	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "20") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		return "get user was called page number " + page + " no of limit per page " + limit + " Sorting as " + sort;

	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		
		String firstName = null;
		int length = firstName.length();
   System.out.println("Print length of firstName: "+length); 
		if (userId != null) {
			return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
		}

	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {

		UserRest returnValue = new UserRest();
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		returnValue.setEmail(userDetails.getEmail());

		String userId = UUID.randomUUID().toString();
		returnValue.setUserId(userId);
		if (users == null) {
			users = new HashMap<String, UserRest>();
			users.put(userId, returnValue);

		}

		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}

	@PutMapping(path = "/{userId}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })

	public UserRest updateUser(@PathVariable String userId,
			@Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
		UserRest StoreUserDetails = users.get(userId);
		StoreUserDetails.setFirstName(userDetails.getFirstName());
		StoreUserDetails.setLastName(userDetails.getLastName());
		users.put(userId, StoreUserDetails);
		return StoreUserDetails;
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		users.remove(id);
		return ResponseEntity.noContent().build();
	}

}

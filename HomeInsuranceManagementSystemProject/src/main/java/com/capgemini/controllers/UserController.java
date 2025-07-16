package com.capgemini.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.User;
import com.capgemini.exceptions.DuplicateUserException;
import com.capgemini.exceptions.InvalidUserException;
import com.capgemini.service.IUserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	IUserService userservice;

	/*
	 * User will be added
	 */
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/users")
	public String addStudent(@RequestBody User user) throws DuplicateUserException {
		User user1 = userservice.addNewUser(user);
		if (user1 != null)
			return "User is added";
		else
			return "User is not added";

	}

	/*
	 * User can sign in
	 */

	@GetMapping("/user/signin/{userName}/{password}/{role}")
    public User signIn(@PathVariable String userName, @PathVariable String password, @PathVariable String role) throws InvalidUserException {
        User user1 = userservice.signIn(userName, password, role);
        if (user1.getUserName() != null && user1.getPassword() != null && user1.getRole() != null) {
            return user1;
        } else {
            throw new InvalidUserException("Inavlid UserName or password");
        }
    }
	
	@GetMapping("/forgotPassword/{userName}")
    public ResponseEntity<String> forgotPassword(@PathVariable String userName) throws InvalidUserException {

 

        String response = userservice.forgotPassword(userName);

 

        if (response != null)
            return new ResponseEntity(response, HttpStatus.OK);
        return new ResponseEntity<String>("Enter valid username", HttpStatus.NOT_FOUND);
    }

	
	/*
	 * invalid user exception
	 */

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = InvalidUserException.class)
	public ResponseEntity<String> handleException(InvalidUserException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/* duplicate user exception */

	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = DuplicateUserException.class)
	public ResponseEntity<String> handleException2(DuplicateUserException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
package com.capgemini.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerException {
	@ExceptionHandler(value = InvalidUserException.class)
	public ResponseEntity<String> exception(InvalidUserException exception) {
		return new ResponseEntity<>("User Not Found", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(value = DuplicateUserException.class)
	public ResponseEntity<String> exception(DuplicateUserException exception) {
		return new ResponseEntity<>("User already exist", HttpStatus.INTERNAL_SERVER_ERROR);

	}

}

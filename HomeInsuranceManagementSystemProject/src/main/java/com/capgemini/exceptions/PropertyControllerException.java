package com.capgemini.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PropertyControllerException {
	@ExceptionHandler(value = PropertyNotFoundException.class)
	public ResponseEntity<String> exception(PropertyNotFoundException exception) {
		return new ResponseEntity<>("Property Not Found", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(value = DuplicatePropertyFoundException.class)
	public ResponseEntity<String> exception(DuplicatePropertyFoundException exception) {
		return new ResponseEntity<>("Property already exist", HttpStatus.INTERNAL_SERVER_ERROR);

	}

}

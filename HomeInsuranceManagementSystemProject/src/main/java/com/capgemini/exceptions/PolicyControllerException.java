package com.capgemini.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PolicyControllerException {
	@ExceptionHandler(value = PolicyNotFoundException.class)
	public ResponseEntity<String> exception(PolicyNotFoundException exception) {
		return new ResponseEntity<>("Policy not found", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = DuplicatePolicyFoundException.class)
	public ResponseEntity<String> exception(DuplicatePolicyFoundException exception) {
		return new ResponseEntity<>("policy already exists", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

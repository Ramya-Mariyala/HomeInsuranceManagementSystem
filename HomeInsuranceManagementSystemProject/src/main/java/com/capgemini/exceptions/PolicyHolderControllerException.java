package com.capgemini.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PolicyHolderControllerException {
	@ExceptionHandler(value = PolicyHolderNotFoundException.class)
	public ResponseEntity<String> exception(PolicyHolderNotFoundException exception) {
		return new ResponseEntity<>("PolicyHolder Not Found", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(value = DuplicatePolicyHolderFoundException.class)
	public ResponseEntity<String> exception(DuplicatePolicyHolderFoundException exception) {
		return new ResponseEntity<>("PolicyHolder already exist", HttpStatus.INTERNAL_SERVER_ERROR);

	}

}

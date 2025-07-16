package com.capgemini.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> exception(Exception exception) {
		return new ResponseEntity<>("Exception is thrown", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

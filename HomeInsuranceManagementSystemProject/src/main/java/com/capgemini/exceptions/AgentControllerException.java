package com.capgemini.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AgentControllerException {

	@ExceptionHandler(value = AgentNotFoundException.class)
	public ResponseEntity<String> exception(AgentNotFoundException exception) {
		return new ResponseEntity<>("Agent not found", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = DuplicateAgentException.class)
	public ResponseEntity<String> exception(DuplicateAgentException exception) {
		return new ResponseEntity<>("Agent already exists", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
package com.capgemini.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class QuoteControllerException {
	@ExceptionHandler(value = QuoteNotFoundException.class)
	public ResponseEntity<String> exception(QuoteNotFoundException exception) {
		return new ResponseEntity<>("Quote not found", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = DuplicateQuoteFoundException.class)
	public ResponseEntity<String> exception(DuplicateQuoteFoundException exception) {
		return new ResponseEntity<>("Quote already exists", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

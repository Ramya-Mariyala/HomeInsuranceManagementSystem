package com.capgemini.exceptions;

public class DuplicatePropertyFoundException extends Exception {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DuplicatePropertyFoundException(Exception e, String message) {
		super(e);
		this.message = message;
	}

	public DuplicatePropertyFoundException(String message) {
		this.message = message;
	}

}

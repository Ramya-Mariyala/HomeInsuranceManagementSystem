package com.capgemini.exceptions;

public class DuplicateAgentException extends Exception {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DuplicateAgentException(Exception e, String message) {
		super(e);
		this.message = message;
	}

	public DuplicateAgentException(String message) {
		this.message = message;
	}

}

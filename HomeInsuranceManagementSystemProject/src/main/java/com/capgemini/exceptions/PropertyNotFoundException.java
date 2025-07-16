package com.capgemini.exceptions;

public class PropertyNotFoundException extends Exception {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PropertyNotFoundException(Exception e, String message) {
		super(e);
		this.message = message;
	}

	public PropertyNotFoundException(String message) {
		this.message = message;
	}

}

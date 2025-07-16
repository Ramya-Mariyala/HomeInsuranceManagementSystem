package com.capgemini.exceptions;

public class AgentNotFoundException extends Exception {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AgentNotFoundException(Exception e, String message) {
		super(e);
		this.message = message;
	}

	public AgentNotFoundException(String message) {
		this.message = message;
	}

}

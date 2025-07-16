package com.capgemini.exceptions;

public class DuplicateQuoteFoundException extends Exception{
    private String message;

 

    public DuplicateQuoteFoundException(Exception e, String message) {
        super();
        this.setMessage(message);
    }
    
    public DuplicateQuoteFoundException(String message) {
        super();
        this.message = message;
    }

 

    public String getMessage() {
        return message;
    }

 

    public void setMessage(String message) {
        this.message = message;
    }
    
}

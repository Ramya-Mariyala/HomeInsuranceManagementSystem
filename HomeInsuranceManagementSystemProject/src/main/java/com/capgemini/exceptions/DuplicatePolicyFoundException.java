package com.capgemini.exceptions;

public class DuplicatePolicyFoundException extends Exception{
    private String message;

 

    public DuplicatePolicyFoundException(Exception e, String message) {
        super();
        this.setMessage(message);
    }
    
    public DuplicatePolicyFoundException(String message) {
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

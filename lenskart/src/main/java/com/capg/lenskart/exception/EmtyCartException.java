package com.capg.lenskart.exception;

public class EmtyCartException extends RuntimeException{
	
	private String message;
	 
    public EmtyCartException() {}
 
    public EmtyCartException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}

package com.capg.lenskart.exception;

public class NoSuchUserFoundException extends RuntimeException{

	private String message;
	 
    public NoSuchUserFoundException() {}
 
    public NoSuchUserFoundException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}

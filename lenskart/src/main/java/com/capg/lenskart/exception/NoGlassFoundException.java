package com.capg.lenskart.exception;

public class NoGlassFoundException extends RuntimeException{
	
	private String message; 
    public NoGlassFoundException() {}
 
    public NoGlassFoundException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}

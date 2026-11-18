package com.capg.lenskart.exception;

public class GlassAlreadyExistsInCartException extends RuntimeException{
	private String message;
	 
    public GlassAlreadyExistsInCartException() {}
 
    public GlassAlreadyExistsInCartException(String msg)
    {
        super(msg);
        this.message = msg;
    }

}

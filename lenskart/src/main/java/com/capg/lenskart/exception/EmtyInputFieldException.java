package com.capg.lenskart.exception;

public class EmtyInputFieldException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;
	 
    public EmtyInputFieldException() {}
 
    public EmtyInputFieldException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}

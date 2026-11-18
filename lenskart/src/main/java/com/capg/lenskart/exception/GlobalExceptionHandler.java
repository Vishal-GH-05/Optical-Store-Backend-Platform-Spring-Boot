package com.capg.lenskart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoSuchUserFoundException.class)
	public ResponseEntity<String> handleNoSuchUserFoundException(NoSuchUserFoundException noSuchUserFoundException){
		return new ResponseEntity<String>("No such user available!",HttpStatus.NOT_FOUND);		
	}
	
	@ExceptionHandler(EmtyCartException.class)
	public ResponseEntity<String> handleEmtyCartException(EmtyCartException emtyCartException){
		return new ResponseEntity<String>("No items available in the cart right now!",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoGlassFoundException.class)
	public ResponseEntity<String> handleNoGlassFoundException(NoGlassFoundException noGlassFoundException){
		return new ResponseEntity<String>("No glasses found!",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmtyInputFieldException.class)
	public ResponseEntity<String> handleEmtyInputFieldException(EmtyInputFieldException noGlassFoundException){
		return new ResponseEntity<String>("No glasses found!",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(GlassAlreadyExistsInCartException.class)
	public ResponseEntity<String> handleGlassAlreadyExistsInCartException(GlassAlreadyExistsInCartException GlassAlreadyExistsInCartException){
		return new ResponseEntity<String>("Item is already in cart",HttpStatus.BAD_REQUEST);
	}
}

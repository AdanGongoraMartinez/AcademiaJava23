package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PokemonRestExceptionHandler {

	// Add an exception handler for CustomerNotFoundException
	
	@ExceptionHandler
	public ResponseEntity<PokemonErrorResponse> handleException(PokemonNotFoundException exc) {
		
		// create CustomerErrorResponse
		
		PokemonErrorResponse error = new PokemonErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	// Add another exception handler ... to catch any exception (catch all)

	@ExceptionHandler
	public ResponseEntity<PokemonErrorResponse> handleException(Exception exc) {
		
		// create CustomerErrorResponse
		
		PokemonErrorResponse error = new PokemonErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}






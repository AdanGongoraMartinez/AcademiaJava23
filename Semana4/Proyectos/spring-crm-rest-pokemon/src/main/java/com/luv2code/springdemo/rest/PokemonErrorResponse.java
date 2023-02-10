package com.luv2code.springdemo.rest;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PokemonErrorResponse {

	private int status;
	private String message;
	private long timeStamp;

	public PokemonErrorResponse(int status, String message, long timeStamp) {
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	
}








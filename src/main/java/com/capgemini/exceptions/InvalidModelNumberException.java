package com.capgemini.exceptions;

public class InvalidModelNumberException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	public InvalidModelNumberException(String message) {
		super(message);
	}


}

package com.capgemini.exceptions;

public class InvalidComplaintIdException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public InvalidComplaintIdException(String message) {
		super(message);
	}


}

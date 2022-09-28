package com.capgemini.exceptions;

public class InvalidEngineerIdException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidEngineerIdException() {
		super("Engineer Id does not exist");
	}

}

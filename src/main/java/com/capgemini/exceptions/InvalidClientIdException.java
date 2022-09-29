package com.capgemini.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidClientIdException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidClientIdException() {
		super("Client ID does not exist.");
	}

}

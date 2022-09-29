package com.capgemini.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidCredentialsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidCredentialsException() {
		super("Invalid Login Credentials, please login again");
	}

}

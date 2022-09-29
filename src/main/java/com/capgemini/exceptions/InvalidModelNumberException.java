package com.capgemini.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidModelNumberException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidModelNumberException() {
		super("Model Number does not exist");
	}

}

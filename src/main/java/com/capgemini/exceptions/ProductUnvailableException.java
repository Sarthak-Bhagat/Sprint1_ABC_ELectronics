package com.capgemini.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductUnvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductUnvailableException() {
		super("This product is already owned by someone.");
	}

}

package com.capgemini.exceptions;

public class OutOfWarrantyException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public OutOfWarrantyException(String message) {
		super(message);
	}

}

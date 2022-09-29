package com.capgemini.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class MyExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleAnyException(Exception exception, WebRequest request) {
		ExceptionDescription descript = new ExceptionDescription(exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionDescription>(descript, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InvalidClientIdException.class)
	public ResponseEntity<?> handleMyOwnException(InvalidClientIdException myException, WebRequest request) {
		ExceptionDescription descript = new ExceptionDescription(myException.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<ExceptionDescription>(descript, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InvalidComplaintIdException.class)
	public ResponseEntity<?> handleMyOwnException(InvalidComplaintIdException myException, WebRequest request) {
		ExceptionDescription descript = new ExceptionDescription(myException.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<ExceptionDescription>(descript, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<?> handleMyOwnException(InvalidCredentialsException myException, WebRequest request) {
		ExceptionDescription descript = new ExceptionDescription(myException.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<ExceptionDescription>(descript, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InvalidEngineerIdException.class)
	public ResponseEntity<?> handleMyOwnException(InvalidEngineerIdException myException, WebRequest request) {
		ExceptionDescription descript = new ExceptionDescription(myException.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<ExceptionDescription>(descript, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InvalidModelNumberException.class)
	public ResponseEntity<?> handleMyOwnException(InvalidModelNumberException myException, WebRequest request) {
		ExceptionDescription descript = new ExceptionDescription(myException.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<ExceptionDescription>(descript, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

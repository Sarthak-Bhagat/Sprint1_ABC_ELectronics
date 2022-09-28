package com.capgemini.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ExceptionDescription {
	private String message;
	private String description;

}

package com.example.hospitalmanagement.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ExceptionHandler extends RuntimeException {

	static final long serialVersionUID=1L;
	public ExceptionHandler(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}	
	
}

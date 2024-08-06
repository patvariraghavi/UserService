package com.example.demo.Exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public String handleResourceNotFoundException(ResourceNotFoundException re) {

		String message = re.getMessage();

		return message;

	}

}

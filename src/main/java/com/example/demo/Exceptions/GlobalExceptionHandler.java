package com.example.demo.Exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public String HandleResourceNotFoundException(ResourceNotFoundException re) 
	{
		
		
		String message = re.getMessage();
		
	
				
				
			
		
		return message; 
		
		
	}
	
	
	
	

}

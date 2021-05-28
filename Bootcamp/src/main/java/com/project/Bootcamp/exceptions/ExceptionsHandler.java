package com.project.Bootcamp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//para controlar quando acontecer algum problema cai nessa classe. problemas de resposta

@ControllerAdvice 
public class ExceptionsHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(BusinessException.class) // quando no service cair no BusinessException. esse metodo da um start
	protected ResponseEntity<ExceptionResponse> handleSecurity(BusinessException e){
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY) //HttpStatus.UNPROCESSABLE_ENTITY da familia 422
				.body(new ExceptionResponse(e.getMessage()));
	}
	
	@ExceptionHandler(NotFoundException.class) // quando no service cair no NotFoundException. esse metodo da um start
	protected ResponseEntity<ExceptionResponse> handleSecurity(NotFoundException e){
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND) //HttpStatus.UNPROCESSABLE_ENTITY da familia 404
				.body(new ExceptionResponse(e.getMessage()));
	}
	
	
}

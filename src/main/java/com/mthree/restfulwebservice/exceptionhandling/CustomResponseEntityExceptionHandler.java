package com.mthree.restfulwebservice.exceptionhandling;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@RestController
@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionResponse handleAllExceptions(Exception ex, WebRequest req) {
		System.out.println("Inside handleAllExceptions of CustomResponseEntityExceptionHandler");
		ExceptionResponse exp = new ExceptionResponse(new Date(), ex.getMessage(), "Detail description of an exception.");
//		return new ResponseEntity(exp, HttpStatus.INTERNAL_SERVER_ERROR);
		return exp;
	}
	
	@ExceptionHandler({UserNotFoundException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ExceptionResponse handleUserNotFoundException(UserNotFoundException ex, WebRequest req) {
		System.out.println("Inside handleUserNotFoundException of CustomResponseEntityExceptionHandler");
		ExceptionResponse exp = new ExceptionResponse(new Date(), ex.getMessage(), "User with requested ID is not available.");
//		return new ResponseEntity(exp, HttpStatus.NOT_FOUND);
		return exp;
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println("Inside handleMethodArgumentNotValid of CustomResponseEntityExceptionHandler");
		ExceptionResponse exp = new ExceptionResponse(new Date(), "Validation Error", ex.getBindingResult().toString());
		return new ResponseEntity(exp, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
}

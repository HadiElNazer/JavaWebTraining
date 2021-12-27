package com.luv2code.spring.firstTest.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.luv2code.spring.firstTest.entity.ErrorResponse;
import com.luv2code.spring.firstTest.exception.MovieAlreadyException;
import com.luv2code.spring.firstTest.exception.MovieNotFoundException;
import com.luv2code.spring.firstTest.exception.MovieRelationException;

@ControllerAdvice
public class MovieRestExceptionHandler {

	@ExceptionHandler

	public ResponseEntity<ErrorResponse> handleException(MovieNotFoundException exc) {
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler

	public ResponseEntity<ErrorResponse> handleException(MovieRelationException exc) {
		ErrorResponse error = new ErrorResponse();
		error.setStatus(460);
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler

	public ResponseEntity<ErrorResponse> handleException(MovieAlreadyException exc) {
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.CONFLICT.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception exc) {
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}

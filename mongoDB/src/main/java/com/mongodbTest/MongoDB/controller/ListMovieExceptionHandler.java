package com.mongodbTest.MongoDB.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mongodbTest.MongoDB.exception.ListMovieAlreadyException;
import com.mongodbTest.MongoDB.exception.ListMovieNotFoundException;
import com.mongodbTest.MongoDB.model.ErrorResponse;

@ControllerAdvice
public class ListMovieExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(ListMovieAlreadyException exc) {
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.CONFLICT.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(ListMovieNotFoundException exc) {
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
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

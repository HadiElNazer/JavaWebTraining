package com.luv2code.spring.firstTest.exception;

public class ListMovieNotFoundException extends RuntimeException {

	public ListMovieNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ListMovieNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ListMovieNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}

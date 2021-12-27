package com.luv2code.spring.firstTest.exception;

public class MovieNotFoundException extends RuntimeException {

	public MovieNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MovieNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MovieNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}

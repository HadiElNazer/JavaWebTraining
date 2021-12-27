package com.luv2code.spring.firstTest.exception;

public class MovieAlreadyException extends RuntimeException {

	public MovieAlreadyException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MovieAlreadyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MovieAlreadyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}

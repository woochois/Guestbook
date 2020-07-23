package com.guest.exceptions;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServiceException(String message, Exception cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}
}

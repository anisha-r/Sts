package com.hcl.course.exception;

public class AuthenticationFailedException extends Exception {

	public AuthenticationFailedException(String exception) {
		super(exception);
	}
	private static final long serialVersionUID = 1L;
}

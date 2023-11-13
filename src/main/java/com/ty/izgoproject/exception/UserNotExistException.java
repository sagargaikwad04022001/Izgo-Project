package com.ty.izgoproject.exception;

public class UserNotExistException extends RuntimeException {

	private String msg;

	public UserNotExistException(String msg) {
		super();
		this.msg = msg;
	}
	@Override
	public String getMessage() {
		return msg;
	}
}

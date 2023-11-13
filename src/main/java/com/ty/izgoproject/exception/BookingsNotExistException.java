package com.ty.izgoproject.exception;

public class BookingsNotExistException extends RuntimeException {

	private String msg;

	public BookingsNotExistException(String msg) {
		super();
		this.msg = msg;
	}
	@Override
	public String getMessage() {
		return msg;
	}
}

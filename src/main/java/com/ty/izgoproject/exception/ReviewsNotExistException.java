package com.ty.izgoproject.exception;

public class ReviewsNotExistException extends RuntimeException {

	private String msg;

	public ReviewsNotExistException(String msg) {
		super();
		this.msg = msg;
	}
	@Override
	public String getMessage() {
		return msg;
	}
}

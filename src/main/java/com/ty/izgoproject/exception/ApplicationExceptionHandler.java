package com.ty.izgoproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.izgoproject.response.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> catchIdNotFound(IdNotFoundException exception)
	{
		ResponseStructure<String> rs=new ResponseStructure<>();
		rs.setMsg("Data Not Found");
		rs.setData(exception.getMessage());
		rs.setStatusCode(HttpStatus.NO_CONTENT.value());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(UserNotExistException.class)
	public ResponseEntity<ResponseStructure<String>> catchUserNotFound(UserNotExistException exception)
	{
		ResponseStructure<String> rs=new ResponseStructure<>();
		rs.setMsg("Data Not Found");
		rs.setData(exception.getMessage());
		rs.setStatusCode(HttpStatus.NO_CONTENT.value());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(BookingsNotExistException.class)
	public ResponseEntity<ResponseStructure<String>> catchBookingsException(BookingsNotExistException exception)
	{
		ResponseStructure<String> rs=new ResponseStructure<>();
		rs.setMsg("Data Not Found");
		rs.setData(exception.getMessage());
		rs.setStatusCode(HttpStatus.NO_CONTENT.value());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(ReviewsNotExistException.class)
	public ResponseEntity<ResponseStructure<String>> catchReviewsException(ReviewsNotExistException exception)
	{
		ResponseStructure<String> rs=new ResponseStructure<>();
		rs.setMsg("Data Not Found");
		rs.setData(exception.getMessage());
		rs.setStatusCode(HttpStatus.NO_CONTENT.value());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NO_CONTENT);
	}
	
}

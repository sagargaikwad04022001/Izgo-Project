package com.ty.izgoproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.izgoproject.entity.Booking;
import com.ty.izgoproject.response.ResponseStructure;
import com.ty.izgoproject.service.BookingService;
@RestController
public class BookingController {

	@Autowired
	private BookingService service;
	
	@PostMapping("booking")
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(@RequestBody Booking booking,@RequestParam int vid,@RequestParam int uid)
	{
		return service.saveBooking(booking, uid, vid);
	}
	
	@GetMapping("booking/{id}")
	public ResponseEntity<ResponseStructure<Booking>> getBookingById(@PathVariable int id)
	{
		return service.getBookingById(id);
	}
	
	@GetMapping("bookingbyuid/{id}")
	public ResponseEntity<ResponseStructure<List<Booking>>> getBookingByUserId(@PathVariable int id)
	{
		return service.getBookingByUserId(id);
	}
	
	@PutMapping("booking")
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(@RequestBody Booking booking)
	{
		return service.updateBooking(booking);
	}
	
	@DeleteMapping("booking/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteBooking(@PathVariable int id) 
	{
		return service.deleteBooking(id);
	}
}

package com.ty.izgoproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.izgoproject.config.EmailConfig;
import com.ty.izgoproject.dao.BookingDao;
import com.ty.izgoproject.dao.UserDao;
import com.ty.izgoproject.dao.VehicleDao;
import com.ty.izgoproject.entity.Booking;
import com.ty.izgoproject.entity.User;
import com.ty.izgoproject.entity.Vehicle;
import com.ty.izgoproject.exception.BookingsNotExistException;
import com.ty.izgoproject.exception.IdNotFoundException;
import com.ty.izgoproject.response.ResponseStructure;


@Service
public class BookingService {

	@Autowired
	private BookingDao dao;
	@Autowired
	private UserDao dao2;
	@Autowired
	private VehicleDao dao3;
	
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(Booking booking,int uid,int vid)
	{
		User customer =dao2.getUserById(uid);
		if(customer!=null)
		{
			booking.setUser(customer);
			Vehicle vehicle=dao3.findVehicleById(vid);
			if(vehicle!=null)
			{
				
				User vehicalOwner = vehicle.getUser();
				
				booking.setVehicle(vehicle);
				dao.saveBooking(booking);
				
				new EmailConfig().sendEmail(customer.getEmail(), vehicalOwner.getEmail(), vehicalOwner.getPassword(), "Booking Request", "I want your car on rent you can contact me on "+ customer.getPhone());
				
				
				return new ResponseEntity<ResponseStructure<Booking>>(new ResponseStructure("Data Saved", HttpStatus.CREATED.value(), booking), HttpStatus.CREATED);
			}
			throw new IdNotFoundException("Vehicle id "+vid+" not exist in database");
		}
		throw new IdNotFoundException("User id "+uid+" not exist in database");
	}
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(Booking booking)
	{
		return new ResponseEntity<ResponseStructure<Booking>>(new ResponseStructure("Data Updated", HttpStatus.OK.value(), dao.updateBooking(booking)), HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Booking>> getBookingById(int id)
	{
		Booking booking=dao.getBookingById(id);
		if(booking!=null)
		{
			return new ResponseEntity<ResponseStructure<Booking>>(new ResponseStructure("Data Found", HttpStatus.FOUND.value(), booking), HttpStatus.FOUND);
		}
		throw new IdNotFoundException("Booking id "+id+" not exist in database");
	}
	
	public ResponseEntity<ResponseStructure<List<Booking>>> getBookingByUserId(int id)
	{
		User user=dao2.getUserById(id);
		if(user!=null)
		{
			List<Booking> bookings=user.getBookings();
			if(bookings!=null && bookings.size()>0)
			{
				return new ResponseEntity<ResponseStructure<List<Booking>>>(new ResponseStructure("Data Found", HttpStatus.FOUND.value(), bookings),HttpStatus.FOUND);
			}
			throw new BookingsNotExistException("Bookings Not Exist for user id "+id);
		}
		throw new IdNotFoundException("User id "+id+" not exist in database");
	}
	public ResponseEntity<ResponseStructure<String>> deleteBooking(int id)
	{
		Booking booking=dao.getBookingById(id);
		if(booking!=null)
		{
			dao.removeBooking(booking);
			return new ResponseEntity<ResponseStructure<String>>(new ResponseStructure("Data Removed", HttpStatus.OK.value(), null), HttpStatus.OK);
		}
		throw new IdNotFoundException("Booking id "+id+" not exist in database");
	}
}

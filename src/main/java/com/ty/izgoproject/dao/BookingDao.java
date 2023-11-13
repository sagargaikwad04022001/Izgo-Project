package com.ty.izgoproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.izgoproject.entity.Booking;
import com.ty.izgoproject.repository.BookingRepository;
@Repository
public class BookingDao {

	@Autowired
	private BookingRepository repository;
	
	
	public Booking saveBooking(Booking booking)
	{
		return repository.save(booking);
	}
	
	public Booking getBookingById(int id)
	{
		Booking booking=repository.findById(id).orElse(null);
		if(booking!=null)
		{
			return booking;
		}
		return null;
	}		
	public Booking updateBooking(Booking booking)
	{
		return repository.save(booking);
	}
	
	public boolean removeBooking(Booking booking)
	{		
		repository.delete(booking);
		return true;		
	}
	public List<Booking> getBookingByUserId(int id)
	{
		List<Booking> bookings=repository.findBookingByUserId(id);
		if(bookings!=null)
		{			
			return bookings;
		}
		return null;
	}
}

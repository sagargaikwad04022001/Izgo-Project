package com.ty.izgoproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.izgoproject.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	List<Booking> findBookingByUserId(int id);

}

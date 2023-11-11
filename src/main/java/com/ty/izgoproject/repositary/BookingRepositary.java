package com.ty.izgoproject.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.izgoproject.entity.Booking;

public interface BookingRepositary extends JpaRepository<Booking, Integer> {

}

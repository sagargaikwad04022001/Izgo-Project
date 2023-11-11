package com.ty.izgoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.izgoproject.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}

package com.ty.izgoproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.izgoproject.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

	List<Review> findByVehicleId(int id);
	
}

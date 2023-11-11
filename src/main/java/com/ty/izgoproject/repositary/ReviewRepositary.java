package com.ty.izgoproject.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.izgoproject.entity.Review;

public interface ReviewRepositary extends JpaRepository<Review, Integer> {

}

package com.ty.izgoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.izgoproject.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}

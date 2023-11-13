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

import com.ty.izgoproject.entity.Review;
import com.ty.izgoproject.response.ResponseStructure;
import com.ty.izgoproject.service.ReviewService;
@RestController
public class ReviewController {

	@Autowired
	private ReviewService service;
	
	@PostMapping("review")
	public ResponseEntity<ResponseStructure<Review>> saveBooking(@RequestBody Review review,@RequestParam int vid,@RequestParam int uid)
	{
		return service.saveReview(review, vid, uid);
	}
	
	@GetMapping("review/{id}")
	public ResponseEntity<ResponseStructure<Review>> getReviewById(@PathVariable int id)
	{
		return service.getReviewById(id);
	}
	
	@GetMapping("reviewvid/{id}")
	public ResponseEntity<ResponseStructure<List<Review>>> getReviewByVehicleId(@PathVariable int id)
	{
		return service.getReviewByVehicleId(id);
	}
	
	@PutMapping("review")
	public ResponseEntity<ResponseStructure<Review>> updateReview(@RequestBody Review review)
	{
		return service.updateReview(review);
	}
	
	@DeleteMapping("review/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteBooking(@PathVariable int id) 
	{
		return service.deleteReview(id);
	}
}

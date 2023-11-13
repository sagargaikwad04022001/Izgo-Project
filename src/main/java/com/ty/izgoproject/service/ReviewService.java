package com.ty.izgoproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.ty.izgoproject.dao.ReviewDao;
import com.ty.izgoproject.dao.UserDao;
import com.ty.izgoproject.dao.VehicleDao;
import com.ty.izgoproject.entity.Review;
import com.ty.izgoproject.entity.User;
import com.ty.izgoproject.entity.Vehicle;
import com.ty.izgoproject.exception.IdNotFoundException;
import com.ty.izgoproject.exception.ReviewsNotExistException;
import com.ty.izgoproject.response.ResponseStructure;
@Service
public class ReviewService {

	@Autowired
	private ReviewDao dao;
	@Autowired
	private VehicleDao dao2;
	@Autowired
	private UserDao dao3;
	
	public ResponseEntity<ResponseStructure<Review>> saveReview(Review review,int vid,int uid)
	{
		Vehicle vehicle=dao2.findVehicleById(vid);
		if(vehicle!=null)
		{
			List<Review> reviews=vehicle.getReviews();
			if(reviews==null && reviews.size()==0)
			{
				reviews=new ArrayList<>();
			}
			review.setVehicle(vehicle);
			User user=dao3.getUserById(uid);
			if(user!=null)
			{
				review.setUser(user);
				dao.saveReview(review);
				reviews.add(review);
				vehicle.setReviews(reviews);
				dao2.updateVehicle(vehicle);
				return new ResponseEntity<ResponseStructure<Review>>(new ResponseStructure("Data Saved", HttpStatus.CREATED.value(), review), HttpStatus.CREATED);
			}
			throw new IdNotFoundException("User id "+uid+" not exist in database");
		}
		throw new IdNotFoundException("Vehicle id "+vid+" is not exist in database");
	}
	
	public ResponseEntity<ResponseStructure<Review>> getReviewById(int id)
	{
		Review review=dao.getReviewById(id);
		if(review!=null)
		{
			return new ResponseEntity<ResponseStructure<Review>>(new ResponseStructure("Data Found", HttpStatus.FOUND.value(), review), HttpStatus.FOUND);
		}
		throw new IdNotFoundException("Vehicle id "+id+" not exist in database");
	}
	
	public ResponseEntity<ResponseStructure<List<Review>>> getReviewByVehicleId(int id)
	{
		Vehicle vehicle=dao2.findVehicleById(id);
		if(vehicle!=null)
		{
			List<Review> reviews=vehicle.getReviews();
			if(reviews!=null && reviews.size()>0)
			{
				return new ResponseEntity<ResponseStructure<List<Review>>>(new ResponseStructure("Data Found", HttpStatus.FOUND.value(), reviews),HttpStatus.FOUND);
			}
			throw new ReviewsNotExistException("Reviews Not Exist for vehicle id "+id);
		}
		throw new IdNotFoundException("Vehicle id "+id+" not exist in database");
	}
	
	public ResponseEntity<ResponseStructure<Review>> updateReview(Review review)
	{
		return new ResponseEntity<ResponseStructure<Review>>(new ResponseStructure("Data Updated",HttpStatus.OK.value(), dao.updateReview(review)),HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteReview(int id)
	{
		Review review=dao.getReviewById(id);
		if(review!=null)
		{
			dao.removeReview(review);
			return new ResponseEntity<ResponseStructure<String>>(new ResponseStructure("Data Removed", HttpStatus.OK.value(), null),HttpStatus.OK);
		}
		throw new IdNotFoundException("Review id "+id+" not exist in database");		
	}
}

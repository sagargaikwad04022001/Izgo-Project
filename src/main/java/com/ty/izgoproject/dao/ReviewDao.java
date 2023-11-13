package com.ty.izgoproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.izgoproject.entity.Review;
import com.ty.izgoproject.repository.ReviewRepository;

@Repository
public class ReviewDao {
	@Autowired
	private ReviewRepository repository;
	
	public Review saveReview(Review review)
	{
		return repository.save(review);
	}
	
	public Review getReviewById(int id)
	{
		Review review=repository.findById(id).orElse(null);
		if(review!=null)
		{
			return review;
		}
		return null;
	}		
	public Review updateReview(Review review)
	{
		return repository.save(review);
	}
	
	public boolean removeReview(Review review2)
	{		
			repository.delete(review2);
			return true;	
	}
	public List<Review> getReviewByVehicleId(int id)
	{
		List<Review> reviews=repository.findByVehicleId(id);
		if(reviews!=null && reviews.size()>0 )
		{			
			return reviews;
		}
		return null;		
	}

	
}

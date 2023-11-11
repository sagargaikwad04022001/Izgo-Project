package com.ty.izgoproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.izgoproject.entity.User;
import com.ty.izgoproject.repository.UserRepository;

@Repository
public class UserDao {
    @Autowired
	private UserRepository repository;
	
	public User saveUser(User user)
	{
		return repository.save(user);
	}
	
	public User getUserById(int id)
	{
		User user=repository.findById(id).orElse(null);
		if(user!=null)
		{
			return user;
		}
		return null;
	}
			
	public User updateUser(User user)
	{
		return repository.save(user);
	}
	
	public boolean removeUser(int id)
	{
		User user=repository.findById(id).orElse(null);
		if(user!=null)
		{
			repository.delete(user);
			return true;
		}
		return false;
	}
	public User getUserByEmailAndPassword(String email,String password)
	{
		User user=repository.findByEmailAndPassword(email,password);
		if(user!=null)
		{
			return user;
		}
		return null;
	}
}

package com.ty.izgoproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ty.izgoproject.dao.UserDao;
import com.ty.izgoproject.entity.User;
import com.ty.izgoproject.exception.IdNotFoundException;
import com.ty.izgoproject.exception.UserNotExistException;
import com.ty.izgoproject.response.ResponseStructure;

public class UserService {

	@Autowired
	private UserDao dao;

	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		
		User user1=dao.saveUser(user);
		return new ResponseEntity<ResponseStructure<User>>(
				new ResponseStructure("Data Saved", HttpStatus.CREATED.value(),user1 ),
				HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> getUserById(int id) {
		User user = dao.getUserById(id);
		if (user != null) {
			return new ResponseEntity<ResponseStructure<User>>(new ResponseStructure<User>("Data Found",HttpStatus.FOUND.value() , user),
					HttpStatus.FOUND);
		}
		throw new IdNotFoundException("User Id:" + id + " Not Exist");
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
		User user2 = dao.updateUser(user);
		return new ResponseEntity<ResponseStructure<User>>(new ResponseStructure<User>("Data Updated",HttpStatus.OK.value() , user2),
				HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure> deleteUserById(int id) {
		
		boolean result=dao.removeUser(id);
		if(result==true)
		{
			return new ResponseEntity<ResponseStructure>(new ResponseStructure("Data Removed",HttpStatus.OK.value(),null),HttpStatus.OK);
		}
		throw new IdNotFoundException("User Id:" + id + " Not Exist");		
	}	
	public ResponseEntity<ResponseStructure<User>> getUserByEmailAndPass(String email, String password) {
		User user=dao.getUserByEmailAndPassword(email, password);
		if(user!=null)
		{
			return new ResponseEntity<ResponseStructure<User>>(new ResponseStructure("Data Found", HttpStatus.FOUND.value(), user), HttpStatus.FOUND);
		}
		throw new UserNotExistException("User email or password incorrect");
	}

	
}

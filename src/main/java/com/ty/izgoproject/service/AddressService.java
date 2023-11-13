package com.ty.izgoproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.izgoproject.dao.AddressDao;
import com.ty.izgoproject.dao.UserDao;
import com.ty.izgoproject.entity.Address;
import com.ty.izgoproject.entity.User;
import com.ty.izgoproject.exception.IdNotFoundException;
import com.ty.izgoproject.response.ResponseStructure;
@Service
public class AddressService {
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private UserDao userDao;
	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address,int uid){
		User user=userDao.getUserById(uid);
		
		if(user!=null)
		{
		Address address1=addressDao.updateAddress(address);
		user.setAddress(address1);
		userDao.updateUser(user);
		return new ResponseEntity<ResponseStructure<Address>>(new ResponseStructure<Address>("Data updated",HttpStatus.OK.value(), address1),HttpStatus.OK);
	
		}
		throw new IdNotFoundException("User id:"+uid+" not exist");
	}
	public ResponseEntity<ResponseStructure<Address>> getAddressByUserId(int id) {
		User user=userDao.getUserById(id);
		if (user!=null) {
			Address address=user.getAddress();
			return new ResponseEntity<ResponseStructure<Address>>(new ResponseStructure<Address>("Data Found", HttpStatus.FOUND.value(), address),HttpStatus.FOUND);
		}
		return new ResponseEntity<ResponseStructure<Address>>(new ResponseStructure<Address>("Data Not Found", HttpStatus.NOT_FOUND.value(), null),HttpStatus.NOT_FOUND);
	}
}

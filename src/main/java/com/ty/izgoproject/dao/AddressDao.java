package com.ty.izgoproject.dao;

<<<<<<< HEAD
=======

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
>>>>>>> 54688918313a8477d86d69ae5c2baf35905e1c92

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.izgoproject.entity.Address;
import com.ty.izgoproject.repository.AddressRepository;

@Repository
public class AddressDao {
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private AddressRepository repository;
	public Address updateAddress(Address address) {
		return addressRepository.save(address);
	}
	
<<<<<<< HEAD

=======
>>>>>>> 54688918313a8477d86d69ae5c2baf35905e1c92
}

package com.ty.izgoproject.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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
	
}

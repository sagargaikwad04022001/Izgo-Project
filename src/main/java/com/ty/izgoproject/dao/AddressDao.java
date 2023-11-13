package com.ty.izgoproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.izgoproject.repository.AddressRepository;

@Repository
public class AddressDao {

	@Autowired
	private AddressRepository repository;
}

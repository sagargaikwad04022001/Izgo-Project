package com.ty.izgoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.izgoproject.entity.Address;
import com.ty.izgoproject.response.ResponseStructure;
import com.ty.izgoproject.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	private AddressService service;
	@GetMapping("address")
	public ResponseEntity<ResponseStructure<Address>> getAddressByUserId(int uid)
	{
		return service.getAddressByUserId(uid);
	}
	@PutMapping("address/{uid}")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@PathVariable int uid,@RequestBody Address address)
	{
		return service.updateAddress(uid,address);
	}
}

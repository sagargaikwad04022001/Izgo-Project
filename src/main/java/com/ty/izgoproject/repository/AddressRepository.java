package com.ty.izgoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.izgoproject.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}

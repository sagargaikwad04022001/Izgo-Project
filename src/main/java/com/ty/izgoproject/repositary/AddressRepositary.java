package com.ty.izgoproject.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.izgoproject.entity.Address;

public interface AddressRepositary extends JpaRepository<Address, Integer> {

}

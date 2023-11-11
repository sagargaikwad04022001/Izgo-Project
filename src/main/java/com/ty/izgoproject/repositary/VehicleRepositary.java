package com.ty.izgoproject.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.izgoproject.entity.Vehicle;

public interface VehicleRepositary extends JpaRepository<Vehicle, Integer>{

}

package com.ty.izgoproject.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.izgoproject.entity.Vehicle;
import com.ty.izgoproject.repository.VehicleRepository;
@Repository
public class VehicleDao {
	@Autowired
	private VehicleRepository vehicleRepository;
	public Vehicle saveVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}
	public Vehicle updateVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}
	public boolean deleteVehicle(int id) {
		Optional<Vehicle> optional=vehicleRepository.findById(id);
		if (optional.isPresent()) {
			Vehicle vehicle=optional.get();
			vehicleRepository.delete(vehicle);
			return true;
		}
		return false;
	}
	public Vehicle findVehicleById(int id) {
		Optional<Vehicle> optional=vehicleRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	public Vehicle findVehicleByVehicleNo(String vehicleNo) {
		Vehicle vehicle =vehicleRepository.findByVehicleNo(vehicleNo);
		if (vehicle!=null) {
			return vehicle;
		}
		return null;
	}
}

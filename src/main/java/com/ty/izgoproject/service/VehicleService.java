package com.ty.izgoproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.izgoproject.dao.UserDao;
import com.ty.izgoproject.dao.VehicleDao;
import com.ty.izgoproject.entity.Booking;
import com.ty.izgoproject.entity.User;
import com.ty.izgoproject.entity.Vehicle;
import com.ty.izgoproject.exception.IdNotFoundException;
import com.ty.izgoproject.response.ResponseStructure;
@Service
public class VehicleService {
	@Autowired
	private VehicleDao vehicleDao;
	@Autowired
	private UserDao userDao;
	public ResponseEntity<ResponseStructure<Vehicle>> saveVehicle(Vehicle vehicle, int uid) {
		   User user=userDao.getUserById(uid);
		   if(user!=null)
		   {
			  vehicle.setUser(user);
			  List<Vehicle> vehicles=user.getVehicles();
			  Vehicle vehicle1=vehicleDao.saveVehicle(vehicle);
			  if(vehicles==null && vehicles.size()==0)
			  {
				  vehicles=new ArrayList<>();
			  }
		      vehicles.add(vehicle1);
		     
		      user.setVehicles(vehicles);
		      userDao.updateUser(user);
			return new ResponseEntity<ResponseStructure<Vehicle>>(
					new ResponseStructure("Data Saved", HttpStatus.CREATED.value(),vehicle1),
					HttpStatus.ACCEPTED);
		   }
		   throw new IdNotFoundException("User Id:" + uid + " Not Exist"); 
		}
	public ResponseEntity<ResponseStructure<Vehicle>> getVehicleById(int id){
		Vehicle vehicle=vehicleDao.findVehicleById(id);
		if (vehicle!=null) {
			return new ResponseEntity<ResponseStructure<Vehicle>>(new ResponseStructure<Vehicle>("Data Found", HttpStatus.FOUND.value(), vehicle),HttpStatus.FOUND);
		}
		throw new IdNotFoundException("User Id:" + id + " Not Exist");
	}
	public ResponseEntity<ResponseStructure<Vehicle>> updateVehicle(Vehicle vehicle){
		Vehicle vehicle1=vehicleDao.saveVehicle(vehicle);
		return new ResponseEntity<ResponseStructure<Vehicle>>(new ResponseStructure<Vehicle>("Data saved",HttpStatus.OK.value(),vehicle1),HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<String>> deleteVehicleById(int id){
		Vehicle vehicle=vehicleDao.findVehicleById(id);
		if (vehicle!=null) {
			
			User user=vehicleDao.findUserByVehicle(vehicle);
			List<Vehicle> vehicles=user.getVehicles();
			for (Vehicle vehicle2 : vehicles) {
				if (vehicle2.equals(vehicle)) {
					vehicles.remove(vehicle2);
				}
				user.setVehicles(vehicles);
				userDao.updateUser(user);
				vehicleDao.deleteVehicle(id);
				return  new ResponseEntity<ResponseStructure<String>>(new ResponseStructure<String>("Data Removed", HttpStatus.OK.value(), null),HttpStatus.OK);
			}
		}
		throw new IdNotFoundException("Vehicle Id:" + id + " Not Exist");
	}
	public ResponseEntity<ResponseStructure<List<Vehicle>>> getAllVehicle(){
		List<Vehicle> vehicles=vehicleDao.displayAllVehicle();
		if (!vehicles.isEmpty()) {
			return new ResponseEntity<ResponseStructure<List<Vehicle>>>(new ResponseStructure<List<Vehicle>>("Data Found", HttpStatus.FOUND.value(), vehicles),HttpStatus.FOUND);
		}
		return new ResponseEntity<ResponseStructure<List<Vehicle>>>(new ResponseStructure<List<Vehicle>>("Data Not Found", HttpStatus.NOT_FOUND.value(), null),HttpStatus.NOT_FOUND);
	}
	public ResponseEntity<ResponseStructure<Vehicle>> getVehicleByVehicleNo(String vehicleNo){
		Vehicle vehicle=vehicleDao.findVehicleByVehicleNo(vehicleNo);
		if (vehicle!=null) {
			return new ResponseEntity<ResponseStructure<Vehicle>>(new ResponseStructure<Vehicle>("Data Found", HttpStatus.FOUND.value(), vehicle),HttpStatus.FOUND);
		}
		throw new IdNotFoundException("Vehicle no:" + vehicleNo + " Not Exist");
	}
}

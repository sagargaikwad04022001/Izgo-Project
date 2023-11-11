package com.ty.izgoproject.entity;


import com.ty.izgoproject.entity.User;
import com.ty.izgoproject.entity.Vehicle;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter

public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double totalCost;
	private String pickupDate;
	private String dropDate;
	private String boardingLoc;
	private String droppingLoc;
	private double initialDistance;
	private double finalDistance;
	private String status;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private  Vehicle vehicle;
	
}

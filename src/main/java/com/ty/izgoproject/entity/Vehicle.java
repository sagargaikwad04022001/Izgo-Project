package com.ty.izgoproject.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter

public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String carName;
	private int noOfSits;
	private double ratePerKM;
	private double mileage;
	private String engineType;
	@Column(nullable = false,unique = true)
	private String vehicleNo;
	
}

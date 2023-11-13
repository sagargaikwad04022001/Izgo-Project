package com.ty.izgoproject.entity;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
	@OneToMany(mappedBy = "vehicle",cascade = CascadeType.REMOVE)
	private List<Review> reviews;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@OneToMany(mappedBy = "vehicle",cascade = CascadeType.REMOVE)
	private List<Booking> bookings;
	
}

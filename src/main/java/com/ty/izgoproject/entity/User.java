package com.ty.izgoproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter

@Table(name="user_details")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;	
	private String name;
	@Column(nullable = false)
	private String email;
	private String password;
	private long Phone;
	private String licenseNo;
	private String role;
	
}

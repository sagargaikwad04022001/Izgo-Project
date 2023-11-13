package com.ty.izgoproject.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter

public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;	
	private String description;
	private double rating;
	@CreationTimestamp
	private LocalDateTime createdDateTime;
	

}

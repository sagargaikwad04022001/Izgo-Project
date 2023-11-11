package com.ty.izgoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.izgoproject.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmailAndPassword(String email, String password);

}
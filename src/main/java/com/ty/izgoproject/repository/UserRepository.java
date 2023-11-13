package com.ty.izgoproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.izgoproject.entity.User;
import com.ty.izgoproject.entity.UserRole;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmailAndPassword(String email, String password);

	List<User> findByRole(UserRole role2);

}

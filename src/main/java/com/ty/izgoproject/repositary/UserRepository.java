package com.ty.izgoproject.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.izgoproject.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

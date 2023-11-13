package com.ty.izgoproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.izgoproject.entity.User;
import com.ty.izgoproject.response.ResponseStructure;
import com.ty.izgoproject.service.UserService;
@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("user")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user)
	{
		return service.saveUser(user);
	}
	
	@GetMapping("user/{id}")
	public ResponseEntity<ResponseStructure<User>> getUserById(@PathVariable int id)
	{
		return service.getUserById(id);
	}
	
	@PutMapping("user")	
	public ResponseEntity<ResponseStructure<User>> updateUser( @RequestBody User user)
	{
		return service.updateUser(user);
	}
	
	@DeleteMapping("user/{id}")
	public ResponseEntity<ResponseStructure> deleteUser(@PathVariable int id)
	{
		return service.deleteUserById(id);
	}	
	@GetMapping("user")
	public ResponseEntity<ResponseStructure<User>> getUserByEmailAndPassword(@RequestParam String email,@RequestParam String password)
	{
		return service.getUserByEmailAndPass(email,password);
	}
	
	@GetMapping("user/{role}")
	public ResponseEntity<ResponseStructure<List<User>>> getUserByRole(String role)
	{
		return service.getByRole(role);
	}
}

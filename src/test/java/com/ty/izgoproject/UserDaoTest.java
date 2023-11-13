package com.ty.izgoproject;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.ty.izgoproject.dao.UserDao;
import com.ty.izgoproject.entity.Address;
import com.ty.izgoproject.entity.User;
import com.ty.izgoproject.entity.UserRole;

class UserDaoTest {

	UserDao dao=new UserDao();
	@Test
	@Disabled
	void save() {
		User user=new User();
		user.setName("virat");
		user.setEmail("sagar@gmail.com");		
		user.setPassword("virat@123");
		user.setPhone(7654321);
		user.setRole(UserRole.CUSTOMER);
		
		Address address=new Address();
		address.setHouseNum(45);
		address.setPincode(123456);
		user.setAddress(address);
		User user2=dao.saveUser(user);
		
		assertNotNull(user2);
	}
	
	@Test
	@Disabled
	void updateUser() {
		User user=new User();
		user.setId(19);
		
		user.setEmail("vk@gmail.com");
		
		User user2=dao.updateUser(user);
		
		assertNotNull(user2);
	}
	@Test
	@Disabled
	void getUserById() {
		User user=dao.getUserById(19);		
		assertNotNull(user);
	}
	
	@Test
	@Disabled
	void getUserByEmailPass()
	{
		User user=dao.getUserByEmailAndPassword("hr@gmail.com", "hr@123");		
		assertNotNull(user);
	}
	@Test
	@Disabled
	void findByRole()
	{
		List<User> users=dao.getUserByRole(UserRole.CUSTOMER);
		assertNotNull(users);
	}
	
	@Test
	@Disabled
	void deleteUser(int id)
	{
		User user=dao.getUserById(id);
		List<User> users=dao.getUserByRole(UserRole.CUSTOMER);
		assertNotNull(users);
	}
	
	
	
	/*
	 * Negative Scenarios
	 */
	@Test
	@Disabled

	void findByRole1()
	{
		List<User> users=dao.getUserByRole(UserRole.CUSTOMER);
		assertNull(users);
	}
	
	@Test
	@Disabled
	void getUserByEmailPass1()
	{
		User user=dao.getUserByEmailAndPassword("hr@gmail.com", "hr@12345");		
		assertNull(user);
	}
	@Test	
	@Disabled
	void getUserById1() {
		User user=dao.getUserById(119);		
		assertNull(user);
	}
	

}

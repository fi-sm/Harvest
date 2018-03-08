package com.sam.ams.rest.service;

import java.util.List;

import com.sam.ams.rest.model.UserTest;





public interface UserTestService {
	
	UserTest findById(long id);
	
	UserTest findByName(String name);
	
	void saveUser(UserTest user);
	
	void updateUser(UserTest user);
	
	void deleteUserById(long id);

	List<UserTest> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(UserTest user);
	
}

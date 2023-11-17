package com.spring.user.UserProfile.service;

import java.util.List;

import com.spring.user.UserProfile.Model.User;



public interface UserService {

	User createUser(User user);

	User getUserById(Long UserId);
	
	List<User> getAllUsers();
	
	User deleteUserById(Long UserId);
	
}

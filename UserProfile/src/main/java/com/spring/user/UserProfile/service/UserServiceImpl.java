package com.spring.user.UserProfile.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.user.UserProfile.Model.User;
import com.spring.user.UserProfile.Repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
//@AllArgsConstructor
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}
	@Override
	public User getUserById(Long UserId) {
		Optional<User> users=userRepository.findById(UserId);
		return users.get();
	}
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = userRepository.findAll();
		System.out.println("Getting data from DB: "+users);
		return users;
	}
}

package com.spring.user.UserProfile.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.user.UserProfile.Model.User;
import com.spring.user.UserProfile.service.UserService;


@RestController
//@AllArgsConstructor
//@RequestMapping("api")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/addUser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User savedUser=userService.createUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	@GetMapping("/getById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long UserId){
		User user = userService.getUserById(UserId);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> user = userService.getAllUsers();
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
}

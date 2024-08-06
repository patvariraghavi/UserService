package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/Users")
@Slf4j

public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userservice;

	@Autowired
	UserRepository userrepository;

	@PostMapping("/createUser")
	public ResponseEntity<String> createUser(@RequestBody User user)

	{

		userservice.saveUser(user);
		logger.info("saving employee");
		return ResponseEntity.status(HttpStatus.OK).body("Created Successfully!!");

	}

	@GetMapping("/getusers")
	public ResponseEntity<List<User>> getUsers()

	{

		List<User> User1 = userservice.getAllUser();
		logger.info("fetched all the employees");
		return ResponseEntity.status(HttpStatus.OK).body(User1);
	}

	@DeleteMapping("/delete/{UserId}")
	public ResponseEntity<String> deleteUsers(@PathVariable String UserId)

	{
		boolean s2 = true;
		boolean s1 = userrepository.existsById(UserId);
		if (s1 == s2) {
			userservice.deleteEmployeeById(UserId);
			logger.info("deleted employee");
			return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully!!");
		}
		return ResponseEntity.status(HttpStatus.OK).body("No Such Record Exists!!");

	}

	@PutMapping("/Update/{UserId}")
	public ResponseEntity<String> updateDataByID(@RequestBody User user, @PathVariable String UserId) {

		boolean s2 = true;
		boolean s1 = userrepository.existsById(UserId);
		if (s1 == s2) {
			userservice.update(user);
			logger.info("Updated employee");
			return ResponseEntity.status(HttpStatus.OK).body("Record Updated Succesfully");
		}
		return ResponseEntity.status(HttpStatus.OK).body("Record doesnot Exists");
	}

}

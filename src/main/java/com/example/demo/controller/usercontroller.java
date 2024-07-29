package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/Users")

public class usercontroller {

	@Autowired
	UserService userservice;

	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user)

	{

		User user1 = userservice.saveUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(user1);

	}

	@GetMapping("/getusers")
	public ResponseEntity<List<User>> getUsers()

	{

		List<User> User1 = userservice.getAllUser();

		return ResponseEntity.status(HttpStatus.OK).body(User1);
	}

//	@DeleteMapping("/delete/{name}")
//	public ResponseEntity<String> deleteUsers(@PathVariable String name)
//
////	{
////		String s1 = userservice.deleteEmployeeByname(name);
////
////		return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully!!");
////
////	}

//	@PutMapping("/Update")
//	public ResponseEntity<User> updateDataByName(@RequestBody User user) {
//
//		User user1 = userservice.update(user);
//		return ResponseEntity.status(HttpStatus.OK).body(user1);
//
//	}

}

package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/Users")
public class usercontroller {
	
	@Autowired
	UserService userservice;
	
	
	
	//Up to date
	
	@PostMapping("/createUser")
	public ResponseEntity<User>  CreateUser(@RequestBody User user )
	
	{
		
		User user1 = userservice.saveUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(user1);
	
	}
	
	@GetMapping("/{UserId}")
    public ResponseEntity<User>  GetUserID(@PathVariable String UserId)
	
	{
		
		User user1 = userservice.getUser(UserId);
		return ResponseEntity.status(HttpStatus.OK).body(user1);
	}
	
	
	
	
	@GetMapping("/getusers")
    public ResponseEntity<List<User>>  GetUsers()
	
	{
		
		List<User> User1 =userservice.getAllUser();
		
		return ResponseEntity.status(HttpStatus.OK).body(User1);
	}
	
	
	
	
	
	
	
	
	
	
	
}


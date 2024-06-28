package com.example.demo.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserImpl implements UserService{
	
	@Autowired
	UserRepository userrepository;
	
	@Autowired
	RestTemplate resttemplate;
	
	
	private Logger logger = LoggerFactory.getLogger(UserImpl.class);
	
	
	
	

	@Override
	public User saveUser(User user) {
		
		String RandomId = UUID.randomUUID().toString();
		user.setUserId(RandomId);
		return userrepository.save(user);
	}

	@Override
	public  List<User> getAllUser() {
		
		ArrayList getforobject = 	resttemplate.getForObject("http://localhost:8085/GetDetails",ArrayList.class);
		
	
		
		 
		
		return   userrepository.findAll();
	}

	
	
	@Override
	public User getUser(String UserId) {
	
		return userrepository.getById(UserId);
				
				
	}

	
	
}

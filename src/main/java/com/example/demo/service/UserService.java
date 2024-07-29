package com.example.demo.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;



public interface UserService {
	
	User saveUser(User user);
	
	
	
	List<User> getAllUser();
	
	
	User getUser(String UserId);
	
	
	

}

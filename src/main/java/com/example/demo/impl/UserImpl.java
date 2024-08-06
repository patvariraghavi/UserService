package com.example.demo.impl;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserImpl implements UserService {

	@Autowired
	UserRepository userrepository;

	private Logger logger = LoggerFactory.getLogger(UserImpl.class);

	@Override
	public User saveUser(User user) {
		String RandomId = UUID.randomUUID().toString();
		user.setUserId(RandomId);
		return userrepository.save(user);
	}

	@Override
	public List<User> getAllUser() {

		return userrepository.findAll();
	}
	
	@Override
	public void deleteEmployeeById(String UserId) {

		userrepository.deleteById(UserId);

	}

	@Override
	public User update(User user) {

		return userrepository.save(user);
	}

	@Override
	public User getUser(String UserId) {
		
		return userrepository.getById(UserId);
	}

}

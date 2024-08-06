package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {

	User saveUser(User user);

	List<User> getAllUser();

	User getUser(String UserId);

	public void deleteEmployeeById(String UserId);

	User update(User user);

}

package com.example.roy.com.service;

import com.example.roy.com.model.User;

public interface UserService {

	public User getNameById(User user);
	
	public Integer addUser(User user);
}

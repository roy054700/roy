package com.example.roy.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.roy.com.dao.UserDao;
import com.example.roy.com.model.User;
import com.example.roy.com.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Override
	public User getNameById(User user) {
		return userDao.getNameById(user);
	}

	@Override
	@Transactional
	public Integer addUser(User user) {
		userDao.addUser(user);
		return 1;
	}
	

}

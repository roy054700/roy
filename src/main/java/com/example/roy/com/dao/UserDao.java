package com.example.roy.com.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.roy.com.model.User;

@Mapper
public interface UserDao {

	public User getNameById(User user);
	
	public Integer addUser(User user);

}

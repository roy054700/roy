package com.example.roy.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.roy.com.model.User;
import com.example.roy.com.service.UserService;

import com.example.roy.com.util.jedis.JedisCluster;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private JedisCluster jedisCluster;
	@RequestMapping("/hello")  
    public String index() {  
         return"Hello World";  
    } 
	 
	 
	 @RequestMapping("/get")  
	 @ResponseBody
    public String get(User user) {  
		String id = jedisCluster.get(user.getId());
		 if(id== null) {
			 User u=userService.getNameById(user);
			 jedisCluster.set(user.getId(), u.toString());
			 return u.toString();
		 }
        return id;     
    }

	 @RequestMapping("/add")  
	 @ResponseBody
    public Integer add(User user) {  
		 Integer u=userService.addUser(user);
		 
        return u;     
    }
}

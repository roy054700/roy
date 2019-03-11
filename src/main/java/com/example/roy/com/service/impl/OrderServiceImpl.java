package com.example.roy.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.roy.com.dao.OrdersMapper;
import com.example.roy.com.model.Orders;
import com.example.roy.com.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	public OrdersMapper ordersMapper;

	@Override
	public int insert(Orders record) {
		return ordersMapper.insert(record);
	}
	
}

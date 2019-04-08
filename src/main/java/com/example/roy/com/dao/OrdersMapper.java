package com.example.roy.com.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.roy.com.model.Orders;
@Mapper
public interface OrdersMapper {
	
    int insert(Orders record);

    int insertSelective(Orders record);
}
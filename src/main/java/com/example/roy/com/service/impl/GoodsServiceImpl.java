package com.example.roy.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.roy.com.dao.GoodsMapper;
import com.example.roy.com.model.Goods;
import com.example.roy.com.service.GoodsService;
@Service
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	public GoodsMapper goodsMapper;
	
	@Override
	public int insert(Goods record) {
		// TODO Auto-generated method stub
		return goodsMapper.insert(record);
	}

	
}

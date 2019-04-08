package com.example.roy.com.service;

import java.util.List;

import com.example.roy.com.model.Goods;

public interface GoodsService {

	 int insert(Goods record);
	 List<Goods> selectList(); 
}

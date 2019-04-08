package com.example.roy.com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.roy.com.model.Goods;
@Mapper
public interface GoodsMapper {
    int insert(Goods record);

	int insertSelective(Goods record);

    List<Goods> selectList();
}
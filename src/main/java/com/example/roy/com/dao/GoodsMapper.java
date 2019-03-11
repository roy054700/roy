package com.example.roy.com.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.roy.com.model.Goods;
@Mapper
public interface GoodsMapper {
    int insert(Goods record);

    int insertSelective(Goods record);
}
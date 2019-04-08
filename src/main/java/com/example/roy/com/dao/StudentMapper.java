package com.example.roy.com.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.roy.com.model.Student;
@Mapper
public interface StudentMapper extends BaseMapper<Student>{
   
}
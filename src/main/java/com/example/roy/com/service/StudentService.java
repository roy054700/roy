package com.example.roy.com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.roy.com.model.Student;

public interface StudentService extends IService<Student>{

	int insert(Student student);
}

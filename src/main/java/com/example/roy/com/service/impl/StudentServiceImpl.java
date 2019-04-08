package com.example.roy.com.service.impl;



import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.roy.com.dao.StudentMapper;
import com.example.roy.com.model.Student;
import com.example.roy.com.service.StudentService;

public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student>  implements StudentService{

	@Autowired
	private StudentMapper studentMapper;

	@Override
	public int insert(Student student) {
		return studentMapper.insert(student);
	}
	
	
}

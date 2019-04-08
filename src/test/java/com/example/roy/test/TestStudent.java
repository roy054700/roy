package com.example.roy.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.roy.base.BaseJunit;
import com.example.roy.com.dao.StudentMapper;
import com.example.roy.com.model.Orders;
import com.example.roy.com.model.Student;
import com.example.roy.com.service.OrderService;

import javafx.application.Application;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes={Application.class})
public class TestStudent extends BaseJunit{
//	@Autowired
//	private StudentService studentService;
	
	@Autowired
	 StudentMapper studentMapper;
	@Autowired
	OrderService orderService;
	private static Student student;
	@Test
	public void insertStudent() {
		Orders record = new Orders();
		record.setGoodsId(1);
		record.setQuantity(99);
		record.setState(44l);
		orderService.insert(record);
//		studentMapper.selectList(null);
//		 student = new Student();
//		student.setId(1);
//		student.setAge(80);
//		student.setName("wangermazi");
//		assertEquals(0,studentMapper.insert(student));
		//studentMapper.insert(student);
		
	}

}

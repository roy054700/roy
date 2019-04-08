package com.example.roy.com.model;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

@TableName("student")
public class Student extends Model<Student>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@TableId("id")
	private Integer id;
	@TableField(value="name")
	private String name;
	@TableField(value="age")
	private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
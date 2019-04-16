package com.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.boot.entity.Student;
@Mapper
public interface StudentMapper {
	int deleteByPrimaryKey(Integer id);
	int insert(Student record);
	int insertSelective(Student record);
	Student selectByPrimaryKey(Integer id);
	List<Student> selectAllStudent();
	int updateByPrimary(Student student);
}

package com.boot.service;

import java.util.List;

import com.boot.entity.Student;

public interface StudentService {
	public List<Student> getAllStudent();
	public int update(Student stu);
}

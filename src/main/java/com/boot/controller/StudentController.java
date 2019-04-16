package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.Student;
import com.boot.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	@RequestMapping("/student")
	public List<Student> getAllStudents(){
		List<Student> list =studentService.getAllStudent();
		return list;
	} 
	
	@RequestMapping("/studentUpdate/{id}/{name}")
	public void updateStudents(@PathVariable("id") Integer id, @PathVariable("name") String name){
		Student stu=new Student();
		stu.setId(id);
		stu.setName(name);
		stu.setAge(22);
		studentService.update(stu);
	} 
}

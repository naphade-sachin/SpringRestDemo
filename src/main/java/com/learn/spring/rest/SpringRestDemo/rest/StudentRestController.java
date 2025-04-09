package com.learn.spring.rest.SpringRestDemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.spring.rest.SpringRestDemo.exception.StudentErrorResponse;
import com.learn.spring.rest.SpringRestDemo.exception.StudentNotFoundException;
import com.learn.spring.rest.SpringRestDemo.pojo.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("api")
public class StudentRestController {
	List<Student> studentList = null;
	
	@PostConstruct
	public void loadData() {
		studentList = new ArrayList<>();
		studentList.add(new Student("Sachin", "Naphade"));
		studentList.add(new Student("Avul", "Reddy"));
		studentList.add(new Student("Lakshmi", "Ganeshan"));
	}
	
	
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		return studentList;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudents(@PathVariable int studentId)
	{
		if(studentList.size()<= studentId || studentId<0) {
			throw new StudentNotFoundException("Student with Id not found:: "+studentId);
		}
		
		return studentList.get(studentId);
	}

	
}


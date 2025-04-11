package com.learn.spring.rest.SpringRestDemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.spring.rest.SpringRestDemo.pojo.Employee;
import com.learn.spring.rest.SpringRestDemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	public EmployeeRestController() {
		super();
	}


	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.getAllEmployee();
		
	}

}

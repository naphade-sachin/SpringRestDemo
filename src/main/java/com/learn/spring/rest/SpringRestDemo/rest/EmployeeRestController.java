package com.learn.spring.rest.SpringRestDemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.spring.rest.SpringRestDemo.dao.impl.EmployeeDaoImpl;
import com.learn.spring.rest.SpringRestDemo.pojo.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeDaoImpl employeeDaoImpl;
	
	
	@Autowired
	public EmployeeRestController(EmployeeDaoImpl employeeDaoImpl) {
		super();
		this.employeeDaoImpl = employeeDaoImpl;
	}

	public EmployeeRestController() {
		super();
	}


	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeDaoImpl.getAllEmployee();
		
	}

}

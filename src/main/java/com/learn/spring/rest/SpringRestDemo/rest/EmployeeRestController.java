package com.learn.spring.rest.SpringRestDemo.rest;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable(name = "employeeId") int employeeId) {
		Employee employee =  employeeService.getEmployee(employeeId);
		if(employee == null) {
			throw new RuntimeException("Employee with Employee id not found:: "+employeeId);
		}
		
		return employee;
		
	}
	
	/*
	 * @PostMapping("/employees}") public Employee
	 * addOrUpdateEmployee(@PathVariable(name = "employeeId") int employeeId) {
	 * return employeeService.getEmployee(employeeId);
	 * 
	 * }
	 */
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		System.out.println("inside addEmployee"+employee.toString());
		employee.setId(0);
		Employee dbEmployee =  employeeService.updateEmployee(employee);
		return dbEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		System.out.println("inside updateEmployee"+employee.toString());
		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		System.out.println("inside deleteEmployee"+employeeId);
		 employeeService.deleteEmployee(employeeId);
		 return "Employee is deleted"+employeeId;
	}

}

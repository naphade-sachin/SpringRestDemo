package com.learn.spring.rest.SpringRestDemo.service;

import java.util.List;

import com.learn.spring.rest.SpringRestDemo.pojo.Employee;

public interface EmployeeService {
	public List<Employee>  getAllEmployee();
	public Employee  getEmployee(int employeeId);
	public Employee  updateEmployee(Employee employee);
	public void  deleteEmployee(int employeeId);
}

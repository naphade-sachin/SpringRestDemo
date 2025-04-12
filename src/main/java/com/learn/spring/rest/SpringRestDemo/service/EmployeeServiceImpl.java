package com.learn.spring.rest.SpringRestDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.spring.rest.SpringRestDemo.dao.impl.EmployeeDaoImpl;
import com.learn.spring.rest.SpringRestDemo.pojo.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDaoImpl employeeDaoImpl;
	
	public EmployeeServiceImpl() {
		super();
	}
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDaoImpl employeeDaoImpl) {
		super();
		this.employeeDaoImpl = employeeDaoImpl;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeDaoImpl.getAllEmployee();
	}

	@Override
	public Employee getEmployee(int employeeId) {
		//get a single Employee based on Id
		return employeeDaoImpl.getEmployee(employeeId);
	}

	@Override
	@Transactional
	public Employee updateEmployee(Employee employee) {
		return employeeDaoImpl.updateEmployee(employee);
	}

	@Override
	@Transactional
	public void deleteEmployee(int employeeId) {
		employeeDaoImpl.deleteEmployee(employeeId);

	}

}

package com.learn.spring.rest.SpringRestDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.spring.rest.SpringRestDemo.dao.impl.EmployeeDaoImpl;
import com.learn.spring.rest.SpringRestDemo.pojo.Employee;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmployee(int employeeId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub

	}

}

package com.learn.spring.rest.SpringRestDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.spring.rest.SpringRestDemo.pojo.Employee;
import com.learn.spring.rest.SpringRestDemo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl() {
		super();
	}
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeDaoImpl) {
		super();
		this.employeeRepository = employeeDaoImpl;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployee(int employeeId) {
		//get a single Employee based on Id
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		Employee theEmployee = null;
		if(employee.isPresent()) {
			theEmployee = employee.get();
		}else {
			throw new RuntimeException("Did not found the employee with Employee Id: "+employeeId);
		}
		
		return theEmployee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);

	}

}

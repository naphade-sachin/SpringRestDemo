package com.learn.spring.rest.SpringRestDemo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.spring.rest.SpringRestDemo.dao.EmployeeDao;
import com.learn.spring.rest.SpringRestDemo.pojo.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private EntityManager entityManager;
	
	public EmployeeDaoImpl() {
		super();
	}
	
	@Autowired
	public EmployeeDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> getAllEmployee() {
		TypedQuery<Employee> theQuery  = (TypedQuery<Employee>) entityManager.createQuery("FROM Employee", Employee.class);
		return theQuery.getResultList();
	}

	@Override
	public Employee getEmployee(int employeeId) {
		return entityManager.find(Employee.class, employeeId);
	}

	@Override
	public Employee updateEmployee(Employee employee) {

		Employee dbEmployee = entityManager.merge(employee);
		return dbEmployee;
	}

	@Override
	public void deleteEmployee(int employeeId) {
		Employee employee =  entityManager.find(Employee.class, employeeId);
		entityManager.remove(employee);
	}

}

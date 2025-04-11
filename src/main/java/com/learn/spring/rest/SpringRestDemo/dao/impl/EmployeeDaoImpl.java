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
		TypedQuery<Employee> theQuery  = (TypedQuery<Employee>) entityManager.createQuery("FROM Employee where id:employeeId", Employee.class);
		theQuery.setParameter("employeeId", "%"+employeeId);
		return theQuery.getResultList().get(0);
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

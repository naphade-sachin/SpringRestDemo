package com.learn.spring.rest.SpringRestDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.spring.rest.SpringRestDemo.pojo.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

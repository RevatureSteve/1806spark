package com.revature.dao;

import java.util.List;

import com.revature.domain.Employee;

public interface EmployeeDao {

	//CREATE
	
	//READ
	public Employee getEmployeeById(int id);
	public List<Employee> getAllEmployees();
	
	//UPDATE
	
	//DELETE
}

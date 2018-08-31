package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDao {

	// CREATE
	
	// READ 
	public Employee getEmployeeByID(int id);
	public List<Employee> getAllEmployees();
	
	// UPDATE
	
	// DELETE
	
}

package com.revature.dao;

import java.util.List;

import com.revature.services.Employee;

public interface EmployeeDao {

	//READ
	public Employee getEmployeeById(int id);
	public List<Employee> getAllEmployees();
	
}

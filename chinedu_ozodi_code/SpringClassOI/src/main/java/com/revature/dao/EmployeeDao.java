package com.revature.dao;

import java.util.List;

import com.revature.bean.Employee;

public interface EmployeeDao {
	
	
	Employee getEmployeeById(int id);
	List<Employee> getAllEmployees();

}

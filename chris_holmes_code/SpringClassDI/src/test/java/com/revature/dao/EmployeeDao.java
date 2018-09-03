package com.revature.dao;

import com.revature.Employee;

public interface EmployeeDao {
	
	public Employee getEmployeeByID(int id) {
		return new Employee("Bobbert", 55, "HR");
	}
	
	public List<Employee> getAllEmployees(){
		return Array;
	}

}

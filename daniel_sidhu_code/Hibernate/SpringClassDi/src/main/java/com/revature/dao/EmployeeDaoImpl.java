package com.revature.dao;

import java.util.Arrays;
import java.util.List;

import com.revature.domain.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	public Employee getEmployeeById(int id) {

		return new Employee("Bobbert", 55, "HR");
	}

	public List<Employee> getAllEmployees() {
		Integer[] spam = new Integer[] {1, 2, 3};
		Arrays.asList(spam);
		
		Employee[] employees = new Employee[] {
				new Employee("John", 25, "DBA"),
				new Employee("Bobbery", 55, "HR"),
				new Employee("Sam",30,"Security")
		};
		
		return Arrays.asList(employees);
	}

	
}

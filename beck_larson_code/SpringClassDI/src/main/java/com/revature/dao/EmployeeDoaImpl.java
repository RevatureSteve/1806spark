package com.revature.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.revature.model.Employee;

public class EmployeeDoaImpl implements EmployeeDao {

	@Override
	public Employee getEmployeeById(int id) {
		
		return new Employee("Bobbert", 55, "HR");
	}

	@Override
	public List<Employee> getAllEmployees() {
		Employee[] employees = new Employee[] {
				new Employee("John", 25, "DBA"),
				new Employee("Bobbert", 44, "HR"),
				new Employee("Mary", 31, "Security"),
				
		};
		return Arrays.asList(employees);
	}

}

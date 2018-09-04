package com.revature.dao;

import java.util.Arrays;
import java.util.List;

import com.revature.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public Employee getEmployeeByID(int id) {
		return new Employee("Bobbert", 55, "HR");
	}

	@Override
	public List<Employee> getAllEmployees() {
		Employee[] employees = new Employee[] {
				new Employee("John", 25, "DBA"),
				new Employee("Bobbert", 55, "HR"),
				new Employee("Sam", 30, "Security"),
		};
		return Arrays.asList(employees);
	}

}

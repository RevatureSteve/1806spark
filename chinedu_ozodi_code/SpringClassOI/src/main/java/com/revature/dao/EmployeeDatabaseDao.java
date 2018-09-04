package com.revature.dao;

import java.util.Arrays;
import java.util.List;

import com.revature.bean.Employee;

public class EmployeeDatabaseDao implements EmployeeDao {

	public Employee getEmployeeById(int id) {
		return new Employee(id,"Bobby Mitchell", 23);
	}

	public List<Employee> getAllEmployees() {
		Employee[] employees = new Employee[] {
				new Employee(1,"Bobby Mitchell", 23),
				new Employee(2,"Bobby Mitchell", 23),
				new Employee(3,"Bobby Mitchell", 23)
		};
		
		return Arrays.asList(employees);
	}
	
	

}

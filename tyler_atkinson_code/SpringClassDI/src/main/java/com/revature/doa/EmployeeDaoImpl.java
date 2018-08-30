package com.revature.doa;

import java.util.Arrays;
import java.util.List;

import com.revature.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	public List <Employee> getAllEmployees(){
		Integer[] spam = new Integer[] {1,2,3}{
			new Employee("John", 25, "DBA"),
			new Employee("Bobbert", 555, "HR"),
			new Employee("Sam", 30, "Security"),
		};
		return Arrays.asList();
	}

}

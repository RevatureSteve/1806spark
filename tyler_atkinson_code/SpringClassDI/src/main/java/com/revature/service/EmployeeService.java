package com.revature.service;

import java.util.List;

import com.revature.doa.EmployeeDao;
import com.revature.model.Employee;

public class EmployeeService {

	EmployeeDao edao;
	
	
	
	public EmployeeService(EmployeeDao edao) {
		super();
		this.edao = edao;
	}

	//Get an employee by id
	public Employee getEmployeeById(int id) {
		System.out.println(" Employee Service - getting" + id);
		return edao.getEmployeeByID(id);
		
	}
	
	//Get all employees
	
	public List<Employee> getAllEmployees() {
		System.out.println("Employee Service - retrieving all Employees");
		return edao.getAllEmployees();
	}
	
	
}

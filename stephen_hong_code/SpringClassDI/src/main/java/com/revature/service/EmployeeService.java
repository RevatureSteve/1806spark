package com.revature.service;

import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.model.Employee;

public class EmployeeService {
	
	private EmployeeDao edao;
	
	public EmployeeService(EmployeeDao edao) {
		super();
		this.edao = edao;
	}

	//	Get an employee by Id
	public Employee getEmployeeById(int id) {
		System.out.println("Employee Service - getting " + id);
		return edao.getEmployeeById(id);
	}
	
	//	Get all employees
	public List<Employee> getAllEmployees() {
		System.out.println("Employee Service - retrieveing all Employees");
		return edao.getAllEmployees();
	}
}

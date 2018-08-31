package com.revature.service;

import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.domain.Employee;

public class EmployeeService {
	private EmployeeDao edao;

	
	public EmployeeService(EmployeeDao edao) {
		super();
		this.edao = edao;
	}

	//get employees by id
	public Employee getEmployeesById(int id) {
		System.out.println("Empoloyee Service - getting " + id);
		return edao.getEmployeeById(id);
	}
	
	//get all employees
	public List<Employee> getAllEmployees() {
		System.out.println("Employee Service - getting all employees");
		return edao.getAllEmployees();
	}

}

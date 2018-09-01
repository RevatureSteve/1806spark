package com.revature.services;

import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.model.Employee;

public class EmployeeService {
	
	private EmployeeDao edao;
	
	

	public EmployeeService(EmployeeDao edao) {
		super();
		this.edao = edao;
	}

	public Employee geEmployeeById(int id) {
		System.out.println("Employee Service - getting " + id);
		return edao.getEmployeeById(id);
	}
	
	public List<Employee> getAllEmployees(){
		System.out.println("Employee Service - retreveing all Employees");
		return edao.getAllEmployees();
	}
	
}

package com.revature.service;

import java.util.List;

import com.revature.bean.Employee;
import com.revature.dao.EmployeeDao;

public class EmployeeService {
	
	private EmployeeDao edao;
	
	public EmployeeService(EmployeeDao edao) {
		super();
		this.edao = edao;
	}

	public Employee getEmployeeById(int id) {
		System.out.println("Employee Service - getting " + id);
		return edao.getEmployeeById(id);
	}
	
	public List<Employee> getAllEmployees() {
		System.out.println("Employee Service - getting all employees");
		return edao.getAllEmployees();
	}

}

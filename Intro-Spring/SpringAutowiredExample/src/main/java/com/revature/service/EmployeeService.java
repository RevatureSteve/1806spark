package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repository.EmpRepo;

@Service
public class EmployeeService implements EmpService {

	@Autowired
	EmpRepo repo;
	
	@Override
	public String getEmployee() {
		System.out.println("Service called to find an employee called Bobbert");
		return repo.findEmployee();
		
	}

}

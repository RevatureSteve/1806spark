package com.ex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ex.dao.Dao;

@Component
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	@Qualifier("daoImpl") //Only need because more than one Dao implementation
	private Dao dao;
	
	public void authenticate(){
		System.out.println("In EmployeeService");
		dao.getEmployeeById();
	}
	
	
}

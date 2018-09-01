package com.ex.dao;

import org.springframework.stereotype.Component;

@Component
public class AnotherDaoImpl implements Dao {

	@Override
	public void getEmployeeById() {
		System.out.println("In AnotherDaoImpl");
	}
	
}

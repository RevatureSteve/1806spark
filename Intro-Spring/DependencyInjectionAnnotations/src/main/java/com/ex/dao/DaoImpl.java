package com.ex.dao;

import org.springframework.stereotype.Component;

@Component
public class DaoImpl implements Dao {
	
	public void getEmployeeById(){
		System.out.println("In DaoImpl");
	}
	
}

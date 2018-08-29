package com.revature.dao;

import com.revature.domain.Employee;


public interface EmployeeDao {
	// Remember that DAO: DATA Access Object (only CRUD Methods!)
	
		//CREATE
		
		//READ
		public Employee getEmployeeByEmail(String email);
		
		//UpDATE
		
		//DELETE
}

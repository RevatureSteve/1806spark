package com.revature.service;

import java.util.List;

import com.revature.dao.EmployeeImpl;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;

public class Service {
	
	private EmployeeImpl emImpl = new EmployeeImpl();
	
	//Login Validation.
	public Users login(String email, String password) {
		
		System.out.println("Starting login service" + email + " " + password);
		System.out.println("Calling EmployeeImpl");
		Users usr = emImpl.getEmpInfo(email, password);
		usr.setEmail(email);
		usr.setPassword(password);
		System.out.println("It is " + usr);
		
		if (usr != null) {
			if (email == usr.getEmail() && password == usr.getPassword()) {
				System.out.println("Success");
				return usr;
			}
		}
		System.out.println("Fail");
		return null;
	}
	
	
	//Reimbursements for an employee.
	public List<Reimbursement> getAllReimbursements(int empId) {
		return emImpl.getAllReimb(empId);
		
	}
	
	
	
	
	
	
	
	

}

package com.revature.service;

import java.util.List;

import com.revature.dao.EmployeeImpl;
import com.revature.dao.ManagerImpl;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;

public class Service {
	
	private EmployeeImpl emImpl = new EmployeeImpl();
	private ManagerImpl mImpl = new ManagerImpl();
	
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
		System.out.println("Starting getAllReimbursements...");
		return emImpl.getAllReimb(empId);
		
	}
	
	
	
	//Get all employees.
	public List<Users> getAllEmployees() {
		System.out.println("Starting getAllEmployees");
		List<Users> usr = mImpl.getEmployees();
		if (usr != null) {
		System.out.println("Got em all!");
		return usr;
		}
		return null;
	}
	
	
	//Get all employee reimbursements.
	
	public List<Reimbursement> getAllEmpReimb() {
		System.out.println("Starting getAllEmpReimb");
		List<Reimbursement> rb = mImpl.getAllEmpReimb();
		if (rb != null) {
		System.out.println("Success!");
		return rb;
		}
		else {
			System.out.println("Failed.");
		}
		return null;
	}
	

}

package com.revature.service;

import java.sql.Timestamp;
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
		
		System.out.println("Starting login service");
		System.out.println("Calling EmployeeImpl");
		Users usr = new Users();
		usr.setEmail(email);
		usr.setPassword(password);
		usr = emImpl.login(usr.getEmail(), usr.getPassword());
		System.out.println(usr);
		
		if (usr != null) {
			
				System.out.println("Success");
				return usr;
			
		}
		System.out.println("Fail");
		return null;
	}
	
	
	//Reimbursements for an employee.
	public List<Reimbursement> getEmpReimbursements(int empId) {
		System.out.println("Starting getAllReimbursements...");
		return emImpl.getEmpReimb(empId);
		
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
	
	public List<Reimbursement> getAllReimb() {
		System.out.println("Starting getAllEmpReimb");
		List<Reimbursement> rb = mImpl.getAllReimb();
		if (rb != null) {
		System.out.println("Success!");
		return rb;
		}
		else {
			System.out.println("Failed.");
		}
		return null;
	}
	
	//Allows employee to submit request.
	public Reimbursement createNewReimbursement(double amount, String rDescription, int uId, int rTypeId, int rStatusId) {
		Reimbursement rb = null;
		System.out.println("Starting createNewReimbursement....");
		int ra =emImpl.createNewReimbursement(amount, rDescription, uId, rTypeId, rStatusId);
		
		if (ra !=0) {
			System.out.println("Success! " + ra + "reimbursement submitted!");
			rb = new Reimbursement(amount,rDescription, rTypeId, rStatusId, uId);
			System.out.println(rb);
		}
		else {
			System.out.println("Failed.");
		}
		return rb;
	}
	
	// Allows a manager to approve or deny(update) a reimbursement request.
	public int updateReimbursements(int rId, int rStatusId) {
		System.out.println("Starting update Reimbursement...");
		int row = mImpl.updateReimbursements(rId, rStatusId);
		if (row != 0 ) {
			System.out.println("Success! " + row + "requests ");
		}
		else {
			System.out.println("Failed");
		}
		
		return rStatusId;
	}
	
	//Updates
	public int updateUserPssword(int uId, String password) {
		System.out.println("Starting update User Password....");
		int row = emImpl.updatePassword(uId, password);
		if (row != 0) {
			System.out.println("Success! ");
		}else {
				System.out.println("Failed");
			}
		return row;
		}
	
	
	
	
	
	
}

package com.revature.service;

import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.dao.UsersDao;
import com.revature.dao.UsersDaoImpl;
import com.revature.domain.Reimbursement;

import com.revature.domain.Users;

public class AppService {
	
	private ReimbursementDao reimbursementDao = new ReimbursementDaoImpl();
	
	//Verify Email and password
	
	private UsersDao usersDao = new UsersDaoImpl();
	
	public Users login(Users userInput) {
		
		System.out.println("[LOG]------Starting Login AppService");
		
		Users validUser = usersDao.getUserByEmail(userInput.getEmail());
	
	if (validUser != null) {
		
		if (validUser.getPassword().equals(userInput.getPassword())) {
			return validUser;
		}
	}

	System.out.println("[LOG]----");
	return null;
}

//view single reimbursement request (NOT WORKING!!)
	
	

	public List<Reimbursement> getReimbursementsById(int u_id){
		
		System.out.println("[LOG]-- retrieving a reimbursement ");
		
		return reimbursementDao.getReimbursemenstById(u_id);
	}
	
	//view reimbursements by emp_u_ud
	
	public List <Reimbursement> getReimbursementByUserId(int emp_u_id){
		
		return reimbursementDao.getReimbursementByUserId(emp_u_id);
	}


	

// view all reimbursements
	public List <Reimbursement> getAllReimbursements(){
		
		System.out.println("[LOG]- retrieving reimbursement list");
		
		return reimbursementDao.getAllReimbursements();
		
	}

// view all users
	
	public List <Users> getAllUsers(){
		System.out.println("[LOG]- Get all users appservice");
		return usersDao.getAllUsers();
	}

//update user profile
	
	public void updateUser(Users b) {
		System.out.println("Appservice");
		usersDao.updateUser(b);
	}
	


// post reimbursement
	
	public List <Reimbursement> addReimbursement(){
		
		System.out.println("[LOG] - submitting reimbursement request");
		return null;
	}


// Update reimbursement
	
	public void changeStatus(int rq_status_id, int r_id){
		
		reimbursementDao.changeStatus(rq_status_id, r_id);
	}







}
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
	


	

// view all reimbursements
	public List <Reimbursement> getAllReimbursements(){
		
		System.out.println("[LOG]- retrieving reimbursement list");
		
		return reimbursementDao.getAllReimbursements();
		
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
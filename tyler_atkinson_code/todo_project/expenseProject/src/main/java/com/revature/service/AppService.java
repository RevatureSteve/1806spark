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
	
	Users dbUser = usersDao.getUserByEmail(userInput.getEmail());
	
	if (dbUser != null) {
		
		if (dbUser.getPassword().equals(userInput.getPassword())) {
			return dbUser;
		}
	}

	
return null;
}

//view single reimbursement request (NOT WORKING!!)

	
	
	public Reimbursement getReReq(Reimbursement userInput) {
		
		Reimbursement dbReimb = reimbursementDao.getReimbursementById(userInput.getR_id());
		
		if (dbReimb != null) {
			
			if (dbReimb.getR_id()==(userInput.getR_id())) {
				return dbReimb;
			}
			

	}
		return dbReimb;
}
	

	public List <Reimbursement> getAllReimbursements(){
		
		System.out.println("[LOG]- retrieving reimbursement list");
		
		return reimbursementDao.getAllReimbursements();
		
	}
	













}
package com.revature.service;

import java.util.List;

import com.revature.dao.ProjectOneDao;
import com.revature.dao.ProjectOneDaoImpl;
import com.revature.pogo.Reimbursement;
import com.revature.pogo.Users;

public class AppService {

	/*
	 * Business logic like login validation
	 * 		validate models before persisting
	 * 		manipulate models before persisting
	 * 		validate user before pulling sensitive data
	 *
	 */
	
	// this object is on the instance scope, so that every non-static method in this class can use the same object 
	private ProjectOneDao projectOneDao = new ProjectOneDaoImpl();
	
	// Login Validation
	public Users login(Users usersEmail) {
		System.out.println("[LOG]---Starting--- Service login() for: " + usersEmail + " information");
		
		// Need to pass the user's email to the dao to see if there is a
		// 	found in the database with that email
		//      Yes - assign the user record to a User java object
		// 		No - then it is null
		System.out.println("[LOG]---calling dao---Service login()");
		// Setting dbEmail by accessing through dao, into daoImpl, with users email by the getEmail method
		Users dbEmail = projectOneDao.getUserByEmail(usersEmail.getEmail());
		System.out.println("[LOG]---dao returned---Service login() returned: " + dbEmail);
		
		// logic to compare user's email to email in Database
		if (dbEmail != null) {
			System.out.println("[LOG]---dbEmail null check---Service login() status: success");
			// compare user's email to dbEmail's password
			if (dbEmail.getPassword().equals(usersEmail.getPassword())) {
				System.out.println("[LOG]---compare password---Service login() password: success");
				// returning dbEmail to Users, not usersEmail
				return dbEmail;
			}
		}
		
		System.out.println("[LOG]---ending---Service login() password: fail");
		return null;
	}
	
	
	// Retrieving User's information by Email
	public Users getUserByEmail(String email) {
		System.out.println("[LOG]---retrieving---User's info");
		
		return projectOneDao.getUserByEmail(email);
	}
	
	
	// Retrieving all the reimbursements
	public List<Reimbursement> getAllReimbursements(){
		System.out.println("[LOG]---retrieving---All Reimbursment");
		
		return projectOneDao.getAllReimbursements();
	}
	
	
	
	






}


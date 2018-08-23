package com.revature.service;

import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.Reimbursement;
import com.revature.domain.Users;

public class BusinessLogic {

	private UserDao usersDao = new UserDaoImpl();
	private ReimbursementDao reimbursementDao = new ReimbursementDaoImpl();
	
	/*
	 *Here is the logic for Users
	 *		it is used to verify login by comparing the input pw against the DB pw 
	 */
	public Users login (String email, String password) {
		System.out.println("[LOG]---Starting---Service login() with the arguments: " + email);

		Users dbUsers = usersDao.getUserByEmail(email);
		System.out.println("[LOG]---Calling the Dao---Service login()");
		
		//checking to see if the DB info is empty
		if (dbUsers != null) {
			System.out.println("[LOG]---dbUsers null check---Service login() status: successful");
			//here we compare the java pw to the sql pw in the database
			if (dbUsers.getPassword().equals(password)) {
				System.out.println("[LOG]---Comparing pw---Service login() pw: successful");
				return dbUsers;//return the DB info
			}
		}
		System.out.println("[LOG]---ending---Service login() pw: fail");
		return null;
	}
	
	/*
	 * Here is the logic to get all Users
	 */
	public List<Users> getAllUsers() {
		System.out.println("[LOG]---retrieving all users---BusinessLogic()");
		return usersDao.getAllUsers();
	}
	
	/*
	 * Here is the logic to get all employees ONLY
	 */
	public List<Users> getAllEmployees() {
		System.out.println("[LOG]---retrieving all employees---BusinessLogic()");
		return usersDao.getAllEmployees();
	}
	
	/*
	 * Here is the logic to get all Reimbursements
	 * 		note: this could use logic but I have not come up with anything yet
	 */
	public List<Reimbursement> getReimbursements() {
		System.out.println("[LOG]---retrieving all reimbursements---BusinessLogic()");
		return reimbursementDao.getReimbursements();	
	}
	
	/*
	 * Here is the logic to get all Pending Reimbursements
	 */
	public List<Reimbursement> getPendingReimbursements() {
		System.out.println("[LOG]---retrieving all pending reimbursements---BusinessLogic()");
		return reimbursementDao.getPendingReimbursements();
	}
	
	/*
	 * Here is the logic to get all Approved Reimbursements
	 */
	public List<Reimbursement> getApprovedReimbursements() {
		System.out.println("[LOG]---retrieving all approved reimbursements---BusinessLogic()");
		return reimbursementDao.getApprovedReimbursements();
	}
	
	public int newReimbursement(Reimbursement reimb) {
		System.out.println("[LOG]---creating a new reimbursement---BusinessLogic()");
		return reimbursementDao.newReimbursement(reimb);
	}
	
}

package com.revature.service;

import java.sql.Timestamp;
import java.util.List;

import com.revature.Dao.RickAndMortyDao;
import com.revature.Dao.RickAndMortyDaoImpli;
import com.revature.Pojo.Reimbursement;
import com.revature.Pojo.Users;

public class AppService {
	
	
	private RickAndMortyDao rmDao = new RickAndMortyDaoImpli();
	private RickAndMortyDaoImpli rmImpli = new RickAndMortyDaoImpli();
	
	public Users login (Users email, Users password) {
		System.out.println("[LOG]------retrieving--------Users Email");
		
		Users uEmail = rmDao.getUserByEmail(email.getEmail(), password.getEmail());
		Users uPassword = rmDao.getUserByEmail(email.getEmail(), password.getEmail());
		System.out.println("Connected to Dao");
		
		
		if (uEmail != null) {
			System.out.println("y..y..Youu don't match anyone here Rick");
			if (uEmail.getPassWord().equals(email.getPassWord())) {
				
				return uEmail;
			}
			
		if (uPassword != null) {
			System.out.println("y..y..Youu don't match anyone here Rick");
			if (uPassword.getEmail().equals(password.getEmail())) {
				
				return uPassword;
			}
		}
		
	}
		
		System.err.println("[LOG]-------Login Failed---------");
		return null;
	}

	
//-------------------------------------------------------------------------------------------------------------------------------
	
	//GET USER BY EMAIL
	
	public Users getUserByEmail(String email, String password) {
		System.out.println("[LOG]---------retrieving-------Users by Email");
		
		return rmDao.getUserByEmail(email, password);
	}
	
	public List<Users> getAllInfo(int u_Id) {
		System.out.println("[LOG]-------Getting Information---------");
		
		return rmDao.getAllInfo(u_Id);
	}
//-------------------------------------------------------------------------------------------------------------------------------
	
	//CREATE REIMBURSEMENT
	
	public int createReimbursement(int emp_U_Id, int amt, String description, int rq_Type) {
		System.out.println("[LOG]---------retrieving--------Create Reimbursement");
		
		return rmDao.createReimbursement(emp_U_Id, amt, description, rq_Type);
	}
	
	public int updateReim(int r_Id, int rq_Status_Id, int mgr_U_Id) {
		int rowsAffected = rmDao.updateReim(r_Id, rq_Status_Id, mgr_U_Id);
		return rowsAffected;
	}

//-------------------------------------------------------------------------------------------------------------------------------
	
	//GET ALL EMPLOYEES
	
	public List<Users> getAllUsers() {
		 System.out.println("[LOG]--------retrieving--------All Users");
		 
		 return rmDao.getAllUsers();
	}
	
	
	
	
//-------------------------------------------------------------------------------------------------------------------------------
	//REIMBURSEMENTS
	
	//GET ALL REIMBURSEMENTS
	
	public List<Reimbursement> getAllReimbursements(){
		System.out.println("[LOG]---------retrieving--------All Reimbursements");
		
		return rmDao.getAllReimbursements();
	}
	
	
	//GET ALL APPROVED
	
	public List <Reimbursement> getAllReimbursementsByApproved(int rq_Status_Id) {
		System.out.println("[LOG]---------retrieving---------All Reimbursements by Status");
		
		return rmDao.getAllReimbursementsByApproved(rq_Status_Id);
		
	}
	
	//GET ALL PENDING
	
	public List <Reimbursement> getAllReimbursementsByPending(int rq_Status_Id) {
		System.out.println("[LOG]---------retrieving---------All Reimbursements by Status");
		
		return rmDao.getAllReimbursementsByPending(rq_Status_Id);
		
	}
	
	//GET ALL DENIED
	
	public List <Reimbursement> getAllReimbursementsByDenied(int rq_Status_Id) {
		System.out.println("[LOG]---------retrieving---------All Reimbursements by Status");
		
		return rmDao.getAllReimbursementsByDenied(rq_Status_Id);
		
	}
	
	

	public List<Reimbursement> getAllReimbursementsByStatusAndId(int emp_U_Id) {
		System.out.println("[LOG]---------retrieving----------All Reimbursements by Status and Id");
		
		return rmDao.getAllReimbursementsByStatusAndId(emp_U_Id);
	}
	
	

//-------------------------------------------------------------------------------------------------------------------------------
	
	//UPDATE USER PASSWORD
	
	public int updateUserInfo(String email, String fName, String lName, int u_Id ) {
		System.out.println("[LOG]----------Update Password---------------");
		
		return rmImpli.updateUserInfo(email, fName, lName, u_Id);
	}
}

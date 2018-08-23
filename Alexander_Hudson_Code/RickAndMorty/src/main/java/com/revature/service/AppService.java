package com.revature.service;

import java.util.List;

import com.revature.Dao.RickAndMortyDao;
import com.revature.Dao.RickAndMortyDaoImpli;
import com.revature.Pojo.Reimbursement;
import com.revature.Pojo.Users;

public class AppService {
	
	
	private RickAndMortyDao rmDao = new RickAndMortyDaoImpli();
	
	
	public Users login (Users email) {
		System.out.println("[LOG]------retrieving--------Users Email");
		
		Users uEmail = rmDao.getUserByEmail(email.getEmail());
		System.out.println("Connected to Dao");
		
		
		if (uEmail != null) {
			
			if (uEmail.getPassWord().equals(email.getPassWord())) {
				
				return uEmail;
			}
		}
		
		System.err.println("[LOG]-------Login Failed---------");
		return null;
	}
	
	
	public Users getUserByEmail(String email) {
		System.out.println("[LOG]---------retrieving-------Users by Email");
		
		return rmDao.getUserByEmail(email);
	}
	
	
	public List<Users> getAllUsers() {
		 System.out.println("[LOG]--------retrieving--------All Users");
		 
		 return rmDao.getAllUsers();
	}
	
	public List<Reimbursement> getAllReimbursements(){
		System.out.println("[LOG]---------retrieving--------All Reimbursements");
		
		return rmDao.getAllReimbursements();
	}
	
	public List <Reimbursement> getAllReimbursementsByApproved(int rq_status_id) {
		System.out.println("[LOG]---------retrieving---------All Reimbursements by Status");
		
		return rmDao.getAllReimbursementsByApproved(rq_status_id);
		
	}
	
	public List <Reimbursement> getAllReimbursementsByPending(int rq_status_id) {
		System.out.println("[LOG]---------retrieving---------All Reimbursements by Status");
		
		return rmDao.getAllReimbursementsByPending(rq_status_id);
		
	}
	
	public List <Reimbursement> getAllReimbursementsByDenied(int rq_status_id) {
		System.out.println("[LOG]---------retrieving---------All Reimbursements by Status");
		
		return rmDao.getAllReimbursementsByDenied(rq_status_id);
		
	}

	public List<Reimbursement> getAllReimbursementsByStatusAndId(int rq_status_id, int emp_u_id) {
		System.out.println("[LOG]---------retrieving----------All Reimbursements by Status and Id");
		
		return rmDao.getAllReimbursementsByStatusAndId(rq_status_id, emp_u_id);
	}
}

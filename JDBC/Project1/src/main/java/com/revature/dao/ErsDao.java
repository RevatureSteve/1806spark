package com.revature.dao;

import java.util.List;

import com.revature.pogo.Reimbursement;
import com.revature.pogo.Users;

public interface ErsDao {
	
	//CREATE
	
	//Employee Cases
	public void submitReimbursementRequest(int emp_u_id, Double amount, String description, String img, int rq_type_id);
	
	//Manager Cases
	
	//READ
	public Users login(String email, String password);
	
	//Employee Cases
	public List<Reimbursement> viewUserPendingRequests(int uId);
	public List<Reimbursement> viewUserResolvedRequests(int uId);
	public Users viewProfile(int uId);
	
	//Manager Cases
	public List<Reimbursement> viewAllPendingRequests();
	public List<Reimbursement> viewAllResolvedRequests();
	public List<Users> viewAllEmployees();
	public List<Reimbursement> viewAllReimbursementRequestById(int uId);
	
	//UPDATE
	
	//Employee Cases
	public void updateProfile(Users user);
	
	//Manager Cases
	public void managePendingRequests(Users user, Reimbursement reimb);
	
	//DELETE
	
	//Employee Cases
	
	//Manager Cases
}

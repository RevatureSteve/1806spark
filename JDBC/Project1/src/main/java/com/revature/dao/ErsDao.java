package com.revature.dao;

public interface ErsDao {
	
	//CREATE
	
	//Employee Cases
	public void submitReimbursementRequest(int emp_u_id, int mgr_u_id, Double amount, String description, String img, int rq_type_id);
	
	//Manager Cases
	
	//READ
	
	//Employee Cases
	public void viewPendingRequests();
	public void viewResolvedRequests();
	public void viewProfile();
	
	//Manager Cases
	public void viewAllPendingRequests();
	public void viewAllResolvedRequests();
	public void viewAllEmployees();
	public void viewReimbursementRequestById();
	
	//UPDATE
	
	//Employee Cases
	public void updateProfile();
	
	//Manager Cases
	public void managePendingRequests();
	
	//DELETE
	
	//Employee Cases
	
	//Manager Cases
}

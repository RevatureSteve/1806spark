package com.revature.service;

import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.domain.Reimbursement;

public class ReimbursementBL {
	
	private ReimbursementDao dao = new ReimbursementDaoImpl();
	
	
	//create
	public void createReimbursement(Reimbursement reim) {
		dao.newReimbursement(reim);
	}
	
	//read
	
	public List<Reimbursement> viewResolvedById(int id) {
		return dao.getEmployeeViewResolved(id);
	}
	
	public List<Reimbursement> resolvedRequests(){
		return dao.getResolvedRequests();
	}
	
	
	
	public List<Reimbursement> viewPending(){
		return dao.viewAllPending();
	}
	
	public List<Reimbursement> viewSingleEmployee(int id){
		return dao.getReimbursementForSingle(id);
	}
	

	List<Reimbursement> employeeViewPending(int id) {
		return dao.getEmployeeViewPending(id);
	}
	


	//update
	public void changeReimStatus(int rID, int mID, int status) {
		
	}

}

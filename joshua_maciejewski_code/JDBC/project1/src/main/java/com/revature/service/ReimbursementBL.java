package com.revature.service;

import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.domain.Reimbursement;

public class ReimbursementBL {
	
	private ReimbursementDao dao = new ReimbursementDaoImpl();
	
	
	public List<Reimbursement> viewPending(){
		return dao.viewAllPending();
	}
	
	public List<Reimbursement> viewSingleEmployee(int id){
		return dao.getReimbursementForSingle(id);
	}
	
	public void changeReimStatus(int rID, int mID, int status) {
	
	}
	
	
	public List<Reimbursement> resolvedRequests(){
		return dao.getResolvedRequests();
	}
	
	List<Reimbursement> employeeViewPending(int id) {
		return dao.getEmployeeViewPending(id);
	}
	
	List<Reimbursement> employeeViewResolved(int id) {
		return dao.getEmployeeViewResolved(id);
	}
	
	public void createReimbursement(Reimbursement reim) {
		
	}
	
	

}

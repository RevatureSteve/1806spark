package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.domain.Reimbursement;

public class ReimbursementBuisnessLogic {

	ReimbursementDao reimbDao = new ReimbursementDao();
	
	/**
	 * takes a list of reimbursements and returns only the pending reimbursements
	 * @param reimbursements
	 * @return
	 */
	public List<Reimbursement> getPendingReimbursements(){
		List<Reimbursement> reimbursements = getAllReimbursemets();
		List<Reimbursement> pendingReimbursement = new ArrayList<>();
		for (Reimbursement r : reimbursements) {
			if (r.getRbStatusId() == 1) {
				pendingReimbursement.add(r);
			}
		}
		return pendingReimbursement;
	}
	
	
	/**
	 * takes a list of reimbursements and returns all resolved reimbursements 
	 * @param reimbursements
	 * @return
	 */
	public List<Reimbursement> getResolvedReimbursements(){
		List<Reimbursement> reimbursements = getAllReimbursemets();
		List<Reimbursement> resolvedReimbursements = new ArrayList<>();
		for (Reimbursement r : reimbursements) {
			if (r.getRbStatusId() != 1) {
				resolvedReimbursements.add(r);
			}
		}
		return resolvedReimbursements;
	}
	
	/**
	 * return a list of all reimbursements
	 * @return
	 */
	public List<Reimbursement> getAllReimbursemets(){
		return reimbDao.getReimbursements();
	}
	
	public List<Reimbursement> getReimbursementById(int id){
		return reimbDao.getReimbursementByEmployeeId(id);
	}
	
	
}

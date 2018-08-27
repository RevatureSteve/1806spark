package com.cpo.services;

import java.util.List;

import com.cpo.doa.ReimbursementDao;
import com.cpo.doa.ReimbursementDatabaseDao;
import com.cpo.model.Reimbursement;

public class ReimbursementService {
	
	private static ReimbursementService instance;
	
	private ReimbursementDao rdd = new ReimbursementDatabaseDao();
	
	private ReimbursementService() {
	}

	public static ReimbursementService getInstance() {
		if (instance == null) {
			instance = new ReimbursementService();
		}
		return instance;
	}
	
	public List<Reimbursement> getAllReimbursements() {
		return rdd.getAllReimbursements();
	}
	
	public List<Reimbursement> getReimbursementByUId(int id) {
		return rdd.getReimbursementsByUId(id);
	}
	
	public int createReimbursement(Reimbursement reimb) {
		//Check type
		if (rdd.getRequestType(reimb.getRqTypeId()) > 0) {
			rdd.updateRequestType(reimb.getRqTypeId(), reimb.getRqType());
		}
		else {
			rdd.createRequestType(reimb.getRqTypeId(), reimb.getRqType());
		}
		return rdd.createReimbursement(reimb);
	}

	public int updateReimbursement(Reimbursement reimb) {
		return rdd.updateReimbursement(reimb);
		
	}
}

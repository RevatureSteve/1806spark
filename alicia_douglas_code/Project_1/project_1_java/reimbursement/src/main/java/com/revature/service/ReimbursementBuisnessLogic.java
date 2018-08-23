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
	 * takes a list of reimbursements and returns only the pending reimbursements by id
	 * @param reimbursements
	 * @return
	 */
	public List<Reimbursement> getPendingReimbursementsById(int id){
		List<Reimbursement> reimbursements = getReimbursementById(id);
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
	 * takes a list of reimbursements and returns all resolved reimbursements by id
	 * @param reimbursements
	 * @return
	 */
	public List<Reimbursement> getResolvedReimbursementsById(int id){
		List<Reimbursement> reimbursements = getReimbursementById(id);
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
	
	/**
	 * returns a list of reimbursements based on user id
	 * @param id
	 * @return
	 */
	public List<Reimbursement> getReimbursementById(int id){
		return reimbDao.getReimbursementByEmployeeId(id);
	}
	
	/**
	 * creates a new reimbursement
	 * @param reimb
	 */
	public void createReimbursement(Reimbursement reimb) {
		reimbDao.createReimbursement(reimb);
	}
	
	/**
	 * updates reimbursement after approved or denied
	 * @param rId
	 * @param mgrId
	 * @param status
	 */
	public Reimbursement updateReimbursement(int rId, int mgrId, int status) {
		Reimbursement reimb = reimbDao.getReimbursementByRId(rId);
		reimbDao.updateReimbursementStatus(reimb, mgrId, status);
		return reimbDao.getReimbursementByRId(rId);
	}
	
	
}

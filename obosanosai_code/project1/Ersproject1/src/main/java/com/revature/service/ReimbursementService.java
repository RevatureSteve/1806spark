package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.domain.Reimbursement;

public class ReimbursementService {

	ReimbursementDao reimbDao = new ReimbursementDao();
	
	/**
	 * filters through all reimbursements and only returns the ones that are pending 
	 */
	public List<Reimbursement> getPendingReimbursements(){
		List<Reimbursement> reimbursements = getAllReimbursemets();
		List<Reimbursement> pendingReimbursement = new ArrayList<>();
		for (Reimbursement r : reimbursements) {
			if (r.getRqStatusId() == 1) {
				pendingReimbursement.add(r);
			}
		}
		return pendingReimbursement;
	}
	
	
	/**
	 *  filters through all reimbursements and only returns the ones that are pending by id
	 */
	public List<Reimbursement> getPendingReimbursementsById(int id){
		List<Reimbursement> reimbursements = getReimbursementById(id);
		List<Reimbursement> pendingReimbursement = new ArrayList<>();
		for (Reimbursement r : reimbursements) {
			if (r.getRqStatusId() == 1) {
				pendingReimbursement.add(r);
			}
		}
		return pendingReimbursement;
	}
	
	
	/**
	 * returns all resolved reimbursements 
	 */
	public List<Reimbursement> getResolvedReimbursements(){
		List<Reimbursement> reimbursements = getAllReimbursemets();
		List<Reimbursement> resolvedReimbursements = new ArrayList<>();
		for (Reimbursement r : reimbursements) {
			if (r.getRqStatusId() != 1) {
				resolvedReimbursements.add(r);
			}
		}
		return resolvedReimbursements;
	}
	
	
	/**
	 * filters through reimbursements returns all resolved reimbursements by id
	 */
	public List<Reimbursement> getResolvedReimbursementsById(int id){
		List<Reimbursement> reimbursements = getReimbursementById(id);
		List<Reimbursement> resolvedReimbursements = new ArrayList<>();
		for (Reimbursement r : reimbursements) {
			if (r.getRqStatusId() != 1) {
				resolvedReimbursements.add(r);
			}
		}
		return resolvedReimbursements;
	}
	
	/**
	 * return a list of all reimbursements
	 */
	public List<Reimbursement> getAllReimbursemets(){
		return reimbDao.getReimbursements();
	}
	
	/**
	 * filters through reimbursements and returns a list of reimbursements by user id
	 */
	public List<Reimbursement> getReimbursementById(int id){
		return reimbDao.getReimbursementByEmployeeId(id);
	}
	
	/**
	 * creates a new reimbursement
	 */
	public void createReimbursement(Reimbursement reimb) {
		reimbDao.createReimbursement(reimb);
	}
	
	/**
	 * updates reimbursement after approved or denied
	 */
	public Reimbursement updateReimbursement(int rId, int mgrId, int status) {
		Reimbursement reimb = reimbDao.getReimbursementByRId(rId);
		reimbDao.updateReimbursementStatus(reimb, mgrId, status);
		return reimbDao.getReimbursementByRId(rId);
	}
	
	
}

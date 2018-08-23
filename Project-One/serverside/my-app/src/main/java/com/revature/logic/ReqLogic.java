package com.revature.logic;

import java.sql.Blob;
import java.util.List;

import com.revature.dao.TranstarReimDaoImpl;
import com.revature.pojo.TranstarReims;

public class ReqLogic {
	
	private TranstarReimDaoImpl rDao = new TranstarReimDaoImpl();
	
	/**
	 * Retrieves all requests from a user. 
	 * @param userId
	 * @return reqs / null
	 */
	public TranstarReims reqs(int userId) {
		TranstarReims reqs = rDao.getUserRequests(userId);
		if(reqs != null) {
			return reqs;
		}
		return null;
	}
	
	/**
	 * Retrieves all requests in the database that are unresolved.
	 * @return reqs
	 */
	
	public List<TranstarReims> allReqs() {
		List<TranstarReims> reqs = rDao.getAllPendingRequests();
		return reqs;
	}
	public List<TranstarReims> allResolvedReqs(int userId) {
		List<TranstarReims> reqs = rDao.getAllResolvedRequests(userId);
		return reqs;
	}
	
	public String createRequest(int emp_id, int amount, String desc, int rq_type) {
		String succ = "Failure";
		int rowsAffected = rDao.submitReimbursment(emp_id, amount, desc, rq_type);
		if(rowsAffected == 1) {
			succ = "Success!";
		}
		
		return succ;
		
	}
}

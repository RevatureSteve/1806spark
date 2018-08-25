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
	public List<TranstarReims> resolvedReqs(int userId) {
		List<TranstarReims> reqs = rDao.getResolvedRequests(userId);
		return reqs;
	}
	public List<TranstarReims> getReq(int reqId, int userId) {
		List<TranstarReims> reqs = rDao.getRequests(reqId, userId);
		return reqs;
	}
	
	public int createRequest(int emp_id, int amount, String desc, int rq_type) {
		int rowsAffected = rDao.submitReimbursment(emp_id, amount, desc, rq_type);
		
		
		return rowsAffected;
	}
	}


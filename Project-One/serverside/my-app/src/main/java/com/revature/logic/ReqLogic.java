package com.revature.logic;

import com.revature.dao.transtarReimDao;
import com.revature.pojo.TranstarReims;

public class ReqLogic {
	
	private transtarReimDao rDao = new transtarReimDao();
	
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
	
	public TranstarReims allReqs() {
		TranstarReims reqs = rDao.getAllPendingRequests();
		return reqs;
	}
}

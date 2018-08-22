package com.revature.logic;

import java.util.List;

import com.revature.dao.TranstarDaoImpl;
import com.revature.pojo.TranstarReims;

public class ReqLogic {
	
	private TranstarDaoImpl rDao = new TranstarDaoImpl();
	
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
}

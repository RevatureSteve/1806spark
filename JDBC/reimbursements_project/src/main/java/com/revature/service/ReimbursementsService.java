package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.domain.Reimbursement;

public class ReimbursementsService {
	private static ReimbursementDao rDao = new ReimbursementDaoImpl();
	public static List<Reimbursement> getPendingOfUser(int id){
		List<Reimbursement> reimbs = rDao.getPendingReimbusementsByUser(id);
		return reimbs;
	}
	public static List<Reimbursement> getResolvedOfUser(int id) {
		List<Reimbursement> reimbs = rDao.getResolvedReimbusementsByUser(id);
		return reimbs;
	}
}

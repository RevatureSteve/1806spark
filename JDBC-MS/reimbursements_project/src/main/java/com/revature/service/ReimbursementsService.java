package com.revature.service;

import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.domain.Reimbursement;

public class ReimbursementsService {
	private static ReimbursementDao rDao = new ReimbursementDaoImpl();

	public static List<Reimbursement> getPendingOfUser(int id) {
		List<Reimbursement> reimbs = rDao.getPendingReimbusementsByUser(id);
		return reimbs;
	}

	public static List<Reimbursement> getResolvedOfUser(int id) {
		List<Reimbursement> reimbs = rDao.getResolvedReimbusementsByUser(id);
		return reimbs;
	}

	public static List<Reimbursement> getReimbursementsOfUser(int id) {
		List<Reimbursement> reimbs = rDao.getReimbusementsByUser(id);
		return reimbs;
	}

	public static int createNewReimbursement(int id, double amount, String description, byte[] imgStr, int rqTypeId) {
		return rDao.submitReimbursement(id, amount, description, imgStr, rqTypeId);

	}

	public static List<Reimbursement> getAllReimbursements() {
		return rDao.getAllReimbursements();
	}

	public static int updateReimbursements(int rId, int rqStatus, int mgrId) {
		return rDao.updateReimbursements(rId, rqStatus, mgrId);
	}
	

}

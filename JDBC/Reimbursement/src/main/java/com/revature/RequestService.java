package com.revature;

import java.util.List;

import com.revature.dao.DaoImpl;
import com.revature.dao.ReimbursementDao;
import com.revature.pojo.Reimbursement;

public class RequestService {
	
	public RequestService() {}

	public void createReimbursement(Reimbursement submit) {
		ReimbursementDao dao = new DaoImpl();
		dao.createReimbursementRequest(submit);
	}

	public void updateReimbursement(Reimbursement request) {

		ReimbursementDao dao = new DaoImpl();
		dao.updateStatus(request);
	}
	
	public List<Reimbursement> getReimbursement(){
		ReimbursementDao dao = new DaoImpl();
		return dao.getAllReimbursement();
	}

}

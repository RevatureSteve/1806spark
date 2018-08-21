package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.pojo.Reimbursement;

public class ReimbursementService {
	
	private ReimbursementDao rb = new ReimbursementDaoImpl();
	
	public List<Reimbursement> getAllReimbursements() {
		// add some validation a little later
		return rb.getAllReimbursements();
	}
	
	public void createReimbursement(int uId, double amt, String desc, byte[] img, int typeId) {
		System.out.println("Create user service reached");
		rb.createNewReimbursement(uId, amt, desc, img, typeId);
	}
}

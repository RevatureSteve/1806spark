package com.cpo.doa;

import java.util.List;

import com.cpo.model.Reimbursement;

public interface ReimbursementDao {


	int createRequestType(int id, String name);
	int createReimbursement(Reimbursement reimb);

	List<Reimbursement> getAllReimbursements();
	int getRequestType(int id);
	List<Reimbursement> getReimbursementsByUId(int id);

	int updateRequestType(int id, String name);
	int updateReimbursement(Reimbursement reimb);



}

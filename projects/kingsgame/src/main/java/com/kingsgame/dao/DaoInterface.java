package com.kingsgame.dao;

import java.util.List;

import com.kingsgame.pojo.Reimbursement;
import com.kingsgame.pojo.Type;
import com.kingsgame.pojo.User;

public interface DaoInterface {

	//any user login
	public User loginUser(String email, String password);
	//mgr user creation
	public int createUser(String email, String password,
			String fname, String lname, int pos_id);
	//emp reimbursement creation
	public int createReimbursement(int emp_u_id, 
			double amt, String description,
			//Object img, 
			int rq_type_id);
	
	public int updateReimbursement(int rid, int mgrid, int rqstatusid);
	//emp/mgr reimbursement finder
	public List<Reimbursement> getEReimbursements(int r_id, int emp_u_id, int mgr_u_id, double amt, int rq_type_id, int rq_status_id);
	
	public List<Reimbursement> getMReimbursement(int emp_u_id, int mgr_u_id);
	
	public List<Reimbursement> getAllReimbursement();
	
	public List<Reimbursement> getMineReimbursement(int u_id);
	
	List<Type> getAllTypes();
	List<User> getAllUsers();

}

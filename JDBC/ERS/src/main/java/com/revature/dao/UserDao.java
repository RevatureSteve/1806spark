package com.revature.dao;

import java.util.List;

import com.revature.POJO.Reimbursement;
import com.revature.POJO.User;

public interface UserDao {
	// Remember that DAO: Data Access Object (only CRUD Methods)
	
	//CREATE
	void makeReimbursement(int u_id, double amt, String desc, int type);
	//READ
	public User getUserByUsername(String email);
	List<User> getManagers(boolean all, int id);
	List<User> getUsers(boolean all, int id);
	List<Reimbursement> getReById(int id, boolean all);
	//UPDATE
	void updateUser(String email, String fname, String lname, int id);
	void updateReStatus(int getuId, int input, int num);

	
	//DELETE
}

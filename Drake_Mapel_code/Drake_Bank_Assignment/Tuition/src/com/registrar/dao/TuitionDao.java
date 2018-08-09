package com.registrar.dao;

import com.registrar.pojo.Account;
import com.registrar.pojo.User;

public interface TuitionDao {
	
	// CREATE
	public void createUserProc(User u);
	public void createStudentAccountProc(Account ac);
	
	// READ
	public User getUserByUsername(String username);
	public void viewBalance(int userId);
	
	// UDATE
	public void addClass(int userId);
	public void dropClasses(int d, int userId);

}

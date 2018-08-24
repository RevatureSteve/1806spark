package com.revature.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.POJO.Reimbursement;
import com.revature.POJO.User;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;

public class AppService {
	/*
	 * business logic like login validation validate models before persisting
	 * manipulate models before persisting validate user before pulling sensitive
	 * data
	 */
	private UserDao userDao = new UserDaoImpl();

	public User login(String email, String pass, int pos) {
		User db_u = userDao.getUserByUsername(email);
		if (db_u != null) {
			if (db_u.getPassword().equals(pass) && pos == db_u.getPosId()) {
				return db_u;
			}
		}
		return null;
	}

	public void UpdateProfile(String email, String fname, String lname, int id) {
		userDao.updateUser(email, fname, lname, id);
	}

	public void makeRe(int u_id, double amt, String desc, int type) {
		userDao.makeReimbursement(u_id, amt, desc, type);
	}

	public List<Reimbursement> getPend(boolean all, int id) {
		List<Reimbursement> re = userDao.getPending(all, id);
		return re;
	}

	public List<Reimbursement> getRes(boolean all, int id) {
		return userDao.getResolved(all, id);
	}

	public void resolveRe(int mid, int sid, int rid) {
		userDao.updateReStatus(mid, sid, rid);
	}

	public List<User> getUsers() {
		return userDao.getUsers();
	}
	public List<User> getManagers(boolean all, int id) {
		return userDao.getManagers(all, id);
	}

	public List<Reimbursement> getReById(int id) {
		return userDao.getReById(id);
	}
}

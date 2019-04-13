package com.revature;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.List;

import com.revature.dao.DaoImpl;
import com.revature.dao.ReimbursementDao;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;

public class Service {

	public User validateUser(String email, String password) {

		ReimbursementDao dao = new DaoImpl();

		User dbUser = dao.getUserByEmail(email);
		if (dbUser != null) {
			if (dbUser.getEmail().equals(email) && dbUser.getPassword().equals(password)) {
				return dbUser;
			}
		}
		return null;
	}
	
	public int updateUser(User user) {
		ReimbursementDao dao = new DaoImpl();
		return dao.updateUser(user);
	}

	public List<User> getUser() {
		ReimbursementDao dao = new DaoImpl();
		return dao.getAllUser();
	}

}

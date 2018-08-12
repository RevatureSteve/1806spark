package com.revature;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.UsersDao;
import com.revature.domain.Users;
import com.revature.service.BuisnessLogic;

public class Driver {

	public static void main(String[] args) {
		
		String email = "ad@gmail.com";
		String password = "111";
		
		Users user = new BuisnessLogic().login(email, password);
		
		if (user == null) {
			System.out.println("Login failed");
		} else {
			System.out.println(user);
		}
		
		System.out.println(new UsersDao().readUsers());
		System.out.println(new ReimbursementDao().getReimbursementByEmployeeId(1));
	}

}

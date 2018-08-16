package com.revature;

import java.util.List;

import com.revature.dao.UsersDao;
import com.revature.domain.Users;

public class Driver {

	public static void main(String[] args) {
		
//		String email = "ad@gmail.com";
//		String password = "111";
//		
//		Users user = new BuisnessLogic().login(email, password);
//		
//		if (user == null) {
//			System.out.println("Login failed");
//		} else {
//			System.out.println(user);
//		}
//		
//		System.out.println(new UsersDao().readUsers());
//		System.out.println(new ReimbursementDao().getReimbursementByEmployeeId(1));
//		System.out.println(new ReimbursementDao().getReimbursements());
		
		
//		Reimbursement reim = new Reimbursement(1,20.00, "FUN", null,1);
//		System.out.println(reim);
		
//		Users user = new Users ("sdoug@gmail.com", "111", "Skye", "Douglas", 2);
//		new UsersDao().createUser(user);
		List<Users> users = new UsersDao().readUsers();
		
		for (Users user : users) {
			System.out.println(user);
		}
		
		
//		System.out.println(new UsersDao().readUsers());
		
//		new ReimbursementDao().createReimbursement(reim);
//		System.out.println(new ReimbursementDao().getReimbursements());

	}

}

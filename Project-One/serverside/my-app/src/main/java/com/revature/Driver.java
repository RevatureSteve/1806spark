package com.revature;

import java.sql.Blob;
import java.util.List;

import com.revature.logic.ReqLogic;
import com.revature.logic.UserLogic;
import com.revature.pojo.TranstarReims;
import com.revature.pojo.TranstarUsers;

public class Driver {
	
	static String email = "yu@transtar.com";
	static String password = "mgr";

	public static void main(String[] args) {
		System.out.println("Testing transtar systems....");
//		TranstarUsers user = new UserLogic().login(email, password);
//		System.out.println("The user is: " + user);
//		List<TranstarUsers> users = new UserLogic().getUsers();
//		System.out.println(users);
//		TranstarReims reqs = new ReqLogic().reqs(1);
//		System.out.println(reqs);
		List<TranstarReims> allReqs = new ReqLogic().allResolvedReqs(1);
		System.out.println(allReqs);
		
//		
//		int emp_id = 1;
//		int amount = 53;
//		String desc = "Explosion";
//		int rq_type = 1;
//		String newReq = new ReqLogic().createRequest(emp_id, amount, desc, rq_type);
//		System.out.println(newReq);
	}

}

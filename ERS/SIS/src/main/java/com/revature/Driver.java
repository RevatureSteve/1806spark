package com.revature;

import java.util.List;

import com.revature.pojos.Reimbursement;
import com.revature.service.Service;

public class Driver {

	public static void main(String[] args) {
		Service s = new Service();
		
		//Login
		System.out.println(s.login("dc@bss.com", "07"));
		
		
		//Reimbursemnts
		List<Reimbursement> rb = s.getAllReimbursements(7);
		System.out.println(rb);

	}

}

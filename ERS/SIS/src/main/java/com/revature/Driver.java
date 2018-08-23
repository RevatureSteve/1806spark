package com.revature;

import java.util.List;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;
import com.revature.service.Service;

public class Driver {

	public static void main(String[] args) {
		Service s = new Service();
		
		//Login
		//System.out.println(s.login("dc@bss.com", "07"));
		
		
		//Reimbursements
		//List<Reimbursement> rb = s.getEmpReimbursements(7);
		//System.out.println(rb);

		
		//All employees.
		//List<Users> ur = s.getAllEmployees();
		//System.out.println(ur);
		
		
		//Get all reimbursements.
//		List<Reimbursement> rbs = s.getAllReimb();
//		System.out.println(rbs);
		
		// Create new reimbursement.
		s.createNewReimbursement(200, "test", 3, "General");
//		
	}

}

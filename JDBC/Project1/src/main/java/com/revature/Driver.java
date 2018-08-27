package com.revature;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.dao.UserDao;
import com.revature.domain.Reimbursement;
import com.revature.domain.Users;
import com.revature.service.BusinessLogic;

public class Driver {

	public static void main(String[] args) {
		//System.out.println("testing...");
		
		/*
		 * Here are the values used to provide to my dao to access the db to login
		 * 		and I am certain this is the same one I will use to login for managers as well
		 * 		since they must provide their own email and pw.
		 */
		/*String email = "dan@yahoo.com";
		String password = "dan123";
		//String fnameInput = "";
		//String lnameInput = "";
		
		Users validUser = new BusinessLogic().login(email, password);
		System.out.println("The user based upon the email and password provided is: \n\t\t" + validUser);*/
		
		/*
		 * Here is the List of Users
		 */
		/*List<Users> allUsers = new UserDaoImpl().getAllUsers();
		System.out.println("Here is the List of all our Users\n" + allUsers);*/
		
		
		/*
		 * Here is the List of Employees
		 */
		/*List<Users> allEmployees = new UserDaoImpl().getAllEmployees();
		System.out.println("Here is the List of all our Users\n" + allEmployees);*/
		
		
		/*
		 * Here is the List of all Reimbursements
		 */
		/*List<Reimbursement> allReimbursements = new ReimbursementDaoImpl().getReimbursements();
		System.out.println("Here is the List of all the Reimbursements\n " + allReimbursements);*/

		
		/*
		 * Here is the List of all Pending Reimbursements
		 */
		/*List<Reimbursement> allPendingReimbursements = new ReimbursementDaoImpl().getPendingReimbursements();
		System.out.println("Here is the List of all the Reimbursements\n " + allPendingReimbursements);*/
	
	
		/*
		 * Here is the List of all Pending Reimbursements
		 */
		/*List<Reimbursement> allApprovedReimbursements = new ReimbursementDaoImpl().getApprovedReimbursements();
		System.out.println("Here is the List of all the Reimbursements\n " + allApprovedReimbursements);*/
		
		/*
		 * Here is where I create a new reimburement
		 */
		/*Reimbursement reimb = new Reimbursement(1, 30.00, "more ammo", 1);
		ReimbursementDao ri = new ReimbursementDaoImpl();
		ri.newReimbursement(reimb);
		System.out.println(ri);*/
	}

}

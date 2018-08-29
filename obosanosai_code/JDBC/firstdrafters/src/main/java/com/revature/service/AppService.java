package com.revature.service;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ManagerDao;
import com.revature.dao.ManagerDaoImpl;
import com.revature.domain.Employee;
import com.revature.domain.Manager;

public class AppService {

	/*
	 *  business logic like login validation
	 *      validate models before persisting
	 *      manipulate models before persisting
	 *      validate user before pulling sensitive data
	 *      etc...
	 */
	
	private ManagerDao managerDao = new ManagerDaoImpl();
	private EmployeeDao employeeDao = new EmployeeDaoImpl();
	
	/**
	 * login() returns a valid user object or return null if the user/pw is invalid;
	 * @param userInput
	 * @return
	 */
	public Manager login(Manager managerInput) {
		System.out.println("[LOG]----Starting----Service login() argument: " + managerInput);
		//First pass the userInput's username to the dao to see if there is a
		//     record found in the database with that username
		//     Yes- assign the user record to a User java object 
		//     No - then it is null
		System.out.println("[LOG]----calling dao----Service login()");
		Manager dbManager = managerDao.getManagerByEmail(managerInput.getEmail());
		System.out.println("[LOG]----dao returned----Service login() returned: " + dbManager);
		 // since the username might  not be found I could get back... check for that!
		if(dbManager != null) {
			System.out.println("[LOG]----dbUser null check----Service login() status: successful");
			// now lets compare the userInput's password to the dbUser's password
			if(dbManager.getPassword().equals(managerInput.getPassword())) {
				System.out.println("[LOG]----compare pw----Service login() pw: success");
				return dbManager; // not userInput since it doesn't have the userId
				
			}
		}
		System.out.println("[LOG]----ending----Service login() pw: ");
		return null;
	}
	public Employee login(Employee employeeInput) {
		System.out.println("[LOG]----Starting----Service login() argument: " + employeeInput);
		//First pass the userInput's username to the dao to see if there is a
		//     record found in the database with that username
		//     Yes- assign the user record to a User java object 
		//     No - then it is null
		System.out.println("[LOG]----calling dao----Service login()");
		Employee dbEmployee = employeeDao.getEmployeeByEmail(employeeInput.getEmail());
		System.out.println("[LOG]----dao returned----Service login() returned: " + dbEmployee);
		 // since the username might  not be found I could get back... check for that!
		if(dbEmployee != null) {
			System.out.println("[LOG]----dbUser null check----Service login() status: successful");
			// now lets compare the userInput's password to the dbUser's password
			if(dbEmployee.getPassword().equals(employeeInput.getPassword())) {
				System.out.println("[LOG]----compare pw----Service login() pw: success");
				return dbEmployee; // not userInput since it doesn't have the userId
				
			}
		}
		System.out.println("[LOG]----ending----Service login() pw: ");
		return null;
	}
}

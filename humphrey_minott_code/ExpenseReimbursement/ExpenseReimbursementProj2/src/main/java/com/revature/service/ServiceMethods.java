package com.revature.service;

import java.util.List;
import java.util.Random;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.Reimbursement;
import com.revature.domain.User;
import com.revature.util.Email;

public class ServiceMethods {
	
	private UserDao userDao = new UserDaoImpl();
	Email email = new Email();
	
	public static String randomPassword() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random random = new Random();
        while (salt.length() < 18) { // length of the password 17!
            int index = (int) (random.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
	public List<Reimbursement> getAllRequest(){
		
		return userDao.getAllRequests();
	}
	
	
	public void submitRequest(Reimbursement request){
		userDao.submitRequest(request);
	}
	
	public List<Reimbursement> getReimbursementByUserId(int id){
		return userDao.getReimbursementsById(id);
	}
	
	public List<Reimbursement> getReimbursementByStatus(int status){
		return userDao.getReimbursementsByStatus(status);
	}
	
	public List<Reimbursement> getReimbursementByStatusAndId(int userId, int status){
		return userDao.getReimbursementsBySubmissionIdAndStatus(userId,status);
	}
	
	public List<User> getAllEmployees(){
		return userDao.getAllEmployees();
	}
	
	public User getEmployeeById(int id){
		return userDao.getEmployeeById(id);
	}

	public  void registerEmployee(User employee){
		email.sendEmail("Registration", employee.getFname() +"\n, You have successfully been registered! \n Your temporary password is: " + randomPassword(), employee.getEmail());
		userDao.registerEmployee(employee);
	}
	//chin2413@gmail.com
	
	public void updateRequestStatus(Reimbursement request) {
		User employee = userDao.getEmployeeById(request.getSubmissionUId());
		System.out.println(request);
		if (request.getRequestStatusId() == 2) {
			email.sendEmail("Request Approved", employee.getFname() + "\n, Your recent request has been Accepted",employee.getEmail());
		}
		else {
			email.sendEmail("Request Denied", employee.getFname() + "\n, Your recent request has been denied","sherronpowell1@yahoo.com");
		}
		userDao.updateRequestStatus(request.getResolvedUId(), request, request.getRequestStatusId());
		
	}
	
	
	public User validateUser(String email, String password) {
		return userDao.getUserByEmailAndPassword(email,password);
	}
	
	
	public void updateEmployeeName(User employee, String fname, String lname) {
		userDao.updateEmployeeName(employee, fname, lname);
	}
	
	public void updateEmployeePassword(User employee, String newPassword) {
		userDao.updateEmployeePassword(employee, newPassword);
	}
	
	

}

package com.revature.service;

import java.util.List;
import java.util.Random;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.Reimbursement;
import com.revature.domain.User;

public class ServiceMethods {
	
	private UserDao userDao = new UserDaoImpl();
	
	public static String randomPassword() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random random = new Random();
        while (salt.length() < 18) { // length of the random string.
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
	
	public List<Reimbursement> getReimbursementByStatus(String status){
		return userDao.getReimbursementsByStatus(status);
	}
	
	public List<Reimbursement> getReimbursementByStatusAndId(int userId, String status){
		return userDao.getReimbursementsBySubmissionIdAndStatus(userId,status);
	}
	
	public List<User> getAllEmployees(){
		return userDao.getAllEmployees();
	}
	
	public User getEmployeeById(int id){
		return userDao.getEmployeeById(id);
	}
	
	public  void registerEmployee(User employee){
		userDao.registerEmployee(employee);
	}
	
	
	public void updateRequestStatus(Reimbursement request) {
		
		userDao.updateRequestStatus(request.getResolvedUId(), request, request.getRequestStatusId());
	}
	
	
	public User validateUser(String email, String password) {
		return userDao.getUserByEmailAndPassword(email,password);
	}
	
	
	

}

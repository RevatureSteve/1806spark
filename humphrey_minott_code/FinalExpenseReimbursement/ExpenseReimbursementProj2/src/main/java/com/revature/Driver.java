package com.revature;

import java.util.Scanner;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;
import com.revature.service.PresentationLogic;
import com.revature.util.Email;
//
public class Driver {
	
	static UserDao x = new UserDaoImpl();
	static Scanner scanny = new Scanner(System.in);
	
	public static void main(String[] args) {
		Email email = new Email();
		
		email.sendEmail("Registration", "Got it", "hcm13c@my.fsu.edu");
		
		
		
		
		
		
		
	}

}

package com.revature.service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.reavture.daoimpl.UserDAOimpl;
import com.revature.beans.User;
import com.revature.dao.*;

public class Verify {
	
		//validate first name
		public boolean validFirstName(String firstname)
		{
			if (validateFirstName(firstname) == true )
			{
				return true;
			}
			return false;
			
		}
		
		public static boolean validateFirstName(String firstname)
		{
				
			return firstname.matches("[a-zA-z]+([ '-][a-zA-Z]+)*");
				
		}
		
	
		//validate last name
		public boolean validLastName(String lastname)
		{
			if (validateLastName(lastname) == true )
			{
				return true;
			}
			return false;
			
		}
		
		public static boolean validateLastName(String lastname)
		{
			return lastname.matches( "[a-zA-z]+([ '-][a-zA-Z]+)*" );
		}
		
		
		//validate username
		public boolean validUsername(String username) 
		{
			if (validateUsername(username) == true )
			{
				return true;
			}
			return false;
		}
		
		public static boolean validateUsername(String username)
		{
			return username.matches( "^[a-z0-9_-]{6,14}$" );
				
		}
		
		//validate password
		public boolean validPassword(String password) 
		{
			if (validatePassword(password) == true )
			{
				return true;
			}
			return false;
		}
		
		/*Passwords will contain at least 1 upper case letter
		Passwords will contain at least 1 lower case letter
		Passwords will contain at least 1 number or special character
		Passwords will contain at least 8 characters in length
		Password maximum length should not be arbitrarily limited*/
		public static boolean validatePassword(String password)
		{
			return password.matches( "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$" );
					
		}
		
		//Check if username already exists
		public boolean usernameExists(String username)
		{
			try {
				List<User> users = new UserDAOimpl().getUsers();
				for(User u: users)
				{
					if(u.getUsername().equals(username))
					{
						return true;
					}
				}
			} catch (SQLException e) {
				System.out.println("Couldn't get username at Verify:  " + e.getMessage());
			}
			return false;
		}

}

package com.revature.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.Task;
import com.revature.domain.User;
import com.revature.util.SetConnectionPropertiesUtil;

public class AppService {

	/*
	 *  business logic like login validation
	 *  	validate models before persisting
	 *  	manipulate models before persisting
	 *  	validate user before pulling sensitive data
	 *  	etc...
	 */
	
	private UserDao userDao = new UserDaoImpl();
	
	/**
	 * login() returns a valid user object or returns null if the user/pw combo is invalid;
	 * @param userInput
	 * @return
	 */
	public User login(User userInput) {
		System.out.println("[LOG]----Starting---Service login() argument: " + userInput);
		// First pass the userInput's username to the dao to see if there is a 
		//		is a record found in the database with that username
		//		Yes - assign the user record to a User java object
		//		No - then it is null
		System.out.println("[LOG]----calling dao---Service login()");
		User dbUser = userDao.getUserByUsername(userInput.getUsername());
		System.out.println("[LOG]----dao returned---Service login() returned: " + dbUser);
		
		// since the username might not be found I could get null back...check for that!
		if(dbUser != null) {
			System.out.println("[LOG]----dbUser null check---Service login() status: successful");
			// now let's compare the userInput's password to the dbUser's password
			if(dbUser.getPassword().equals(userInput.getPassword())) {
				System.out.println("[LOG]----compare pw---Service login() pw: success");
				return dbUser; // not userInput since it doesn't have the userId
			}
		}
		System.out.println("[LOG]----ending---Service login() pw: fail");
		return null;
	}
	
	public List<Task> getAllTasks()
	{
		System.out.println("LOG---retrieving----all users");
		//Call DAO to get data from the database.
		List<Task> list = new ArrayList();
		try {
			Connection conn = SetConnectionPropertiesUtil.getConnection();
			String sql = "SELECT * FROM task";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Task(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
		
	}
}

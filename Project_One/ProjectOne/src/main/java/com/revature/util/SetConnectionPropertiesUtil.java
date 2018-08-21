package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SetConnectionPropertiesUtil {
	
	
	/*
	 * 	Utility class helper methods not specific to manipulation of pojos
	 * 		as that would be business logic in services
	 */

	// JDBC connection done through a text file (db.properties)
	


	
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		
		String url;
		String username;
		String password;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties props = new Properties();
		props.load( new FileReader("C:\\Users\\Alex Moraga\\my_git_repos\\1806spark\\Project_One\\ProjectOne\\src\\main\\resources\\db.properties"));
	
		url = props.getProperty("url");
		username = props.getProperty("username");
		password = props.getProperty("password");
		
		return DriverManager.getConnection(url, username, password);
	} 
	
	
}

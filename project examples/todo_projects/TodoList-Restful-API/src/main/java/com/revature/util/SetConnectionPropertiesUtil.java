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
	 * 	utility class helper methods not specific to manipulation of pojos
	 * 		as that would be business logic in services
	 * 	usually for configuration
	 */
	//	let the developer that needs a connection handle these exceptions
	public static Connection getConnection() {
		
		Connection conn = null;
		
		Properties prop = new Properties();
	
		try {
			
			//load in values from properties file
			prop.load(new FileReader("C:\\Users\\Stephen Hong\\my_git_repos\\1806spark\\project examples\\todo_projects\\TodoList-Restful-API\\src\\main\\resources\\application.properties"));
			
			//gets class path to load and register the oracle driver
			Class.forName(prop.getProperty("driver"));	
			
			//establish connection
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("usr"), 
					prop.getProperty("pw"));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return conn;
	}

}

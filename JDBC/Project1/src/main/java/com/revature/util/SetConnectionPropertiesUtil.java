package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SetConnectionPropertiesUtil {
	
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		
		//here I define my variable that I am using to call from the db.properties file in src/main/resources 
		String username;
		String password;
		String url;
		
		//here I have created an instance of a driver and register it with the DriverManager
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//Here is my url, username and password which is bad to leave out in the open but this is only temporary
		/*url = "jdbc:oracle:thin:@octocat.cxwq5mzpnovv.us-east-2.rds.amazonaws.com:1521:ORCL";
		username = "ERS_db";
		password = "p4ssw0rd";*/
		
		/*
		 * we require an absolute path over the relative path
		 * 		note: more research needed to know this
		 */
		
		Properties props = new Properties();
		props.load(new FileReader("C:\\Users\\sidhu\\my_git_repos\\1806spark\\JDBC\\Project1\\src\\main\\resources\\db.properties"));
		
		//here I grab those values in the db.properties file
		url = props.getProperty("url");
		username = props.getProperty("username");
		password = props.getProperty("password");
		
		
		//send the DriverManager back to whatever the Dao implements
		return DriverManager.getConnection(url, username, password);
	
	} 
}

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
		
		Properties props = new Properties();
		props.load(new FileReader("src\\main\\resources\\db.properties"));
		
		//here I grab those values in the db.properties file
		url = props.getProperty("url");
		username = props.getProperty("username");
		password = props.getProperty("password");
		
		//send the DriverManager back to whatever the Dao implements
		return DriverManager.getConnection(url, username, password);
	
	} 
}

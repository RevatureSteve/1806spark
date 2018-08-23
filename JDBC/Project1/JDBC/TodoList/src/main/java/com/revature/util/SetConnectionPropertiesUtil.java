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
	 * utility class helper methods not specific to manipulation of pojos
	 * 		as that would be business logic in services
	 * usually for configuration
	 */
	
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		
		String username;
		String password;
		String url;
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		/*Properties props = new Properties();
		props.load(new FileReader("src\\main\\resources\\db.properties"));
		
		url = props.getProperty("url");
		username = props.getProperty("username");
		password = props.getProperty("password");*/
		
		url="jdbc:oracle:thin:@octocat.cxwq5mzpnovv.us-east-2.rds.amazonaws.com:1521:ORCL";
		username="todo_db";
		password="p4ssw0rd";
		
		return DriverManager.getConnection(url, username, password);
		
	}
	
	
}

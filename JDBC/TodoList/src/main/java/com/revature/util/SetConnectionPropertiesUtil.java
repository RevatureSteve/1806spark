package com.revature.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SetConnectionPropertiesUtil {
	
	/*
	 * utility class helper methods not specified to manipulation of pojos
	 * 		as that would be business logic in services
	 * usually for configuration
	 */
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		String username = "todo_db";
		String password = "p4ssw0rd";
		String url = "jdbc:oracle:thin:@octowolf.crtsillkaxup.us-east-2.rds.amazonaws.com:1521:ORCL";
		
		return DriverManager.getConnection(url, username, password);	
	}
}

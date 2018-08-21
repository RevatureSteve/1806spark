package com.revature.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionsPropertiesUtil {

public static Connection newConnection() throws SQLException {
		
		final String URL = "jdbc:oracle:thin:gooddata.chd4toccqgaj.us-east-2.rds.amazonaws.com:1521:ORCL";
		final String USERNAME = "transtar";
		final String PASSWORD = "p4ssw0rd";
		
	
		try {
			System.out.println("Attempting to connect...");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("try completed");
		} catch (ClassNotFoundException e) {
			System.out.println("Connection failed...");
			
		}
		
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
}

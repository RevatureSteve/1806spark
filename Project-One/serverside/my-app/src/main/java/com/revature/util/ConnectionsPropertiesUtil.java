package com.revature.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionsPropertiesUtil {

public static Connection newConnection() throws FileNotFoundException, IOException, SQLException {
		
		final String URL = "jdbc:oracle:thin:gooddata.chd4toccqgaj.us-east-2.rds.amazonaws.com:1521:ORCL";
		final String USERNAME = "transtar";
		final String PASSWORD = "p4ssw0rd";
		
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
}

package com.revature.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Setting up connection to talk to the DB, where we'd pull/insert info.
public class ConnectionUtil {
	
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		final String url = "jdbc:oracle:thin:@areah.cszwhyxgdjx2.us-east-2.rds.amazonaws.com:1521:ORCL";
		final String username = "project1_db";
		final String password = "p4ssw0rd";
		return DriverManager.getConnection(url, username, password);
		
	}
}

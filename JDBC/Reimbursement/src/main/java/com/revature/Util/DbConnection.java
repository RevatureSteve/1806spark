package com.revature.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {

	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	
	String username = "reimburse_db";
	String password = "p4ssw0rd";
	String URL = "jdbc:oracle:thin:@octocat.cc0hd2rbzuaq.us-east-2.rds.amazonaws.com:1521:ORCL";

	
	return DriverManager.getConnection(URL, username, password);
	}

}

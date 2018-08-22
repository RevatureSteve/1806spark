package com.revature.util;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
	
	final static String username = "ERS_PROJ1";
	final static String password= "p4ssw0rd";
	final static String url = "jdbc:oracle:thin:@octohumphrey.cnwfdjrtsq2o.us-east-2.rds.amazonaws.com:1521:ORCL";
	
	
public static Connection getConnection() throws SQLException, ClassNotFoundException{
	
	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		return DriverManager.getConnection(url, username, password);
		
		
	}

}

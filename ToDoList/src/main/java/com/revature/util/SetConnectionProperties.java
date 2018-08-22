package com.revature.util;  //These classes mainly for configuration stuff

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SetConnectionProperties {
	
	/*
	 * Utility class helper methods not specific to manipulation of pojos
	 * 		as that would be business logic in service
	 */
	
	//What do I need for a JDBC Connection

	// and the DRIVER which is the JAR for that specific 
	
	public static Connection getConnection() throws FileNotFoundException,IOException, SQLException, ClassNotFoundException{
		
		final String username="todo_db";
		final String password="p4ssw0rd";
		final String url = "jdbc:oracle:thin:@octohumphrey.cnwfdjrtsq2o.us-east-2.rds.amazonaws.com:1521:ORCL";
//		Properties props = new Properties();
//		props.load(new FileReader("/Users/humphreyminott/my_git_repos/1806spark/ToDoList/src/main/resources/db.properties"));
		Class.forName("oracle.jdbc.driver.OracleDriver");

		
		return DriverManager.getConnection(url, username, password);
		
		
	}
}

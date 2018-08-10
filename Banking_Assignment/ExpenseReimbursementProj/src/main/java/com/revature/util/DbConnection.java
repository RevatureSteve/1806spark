package com.revature.util;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
	
	
public static Connection getConnection() throws FileNotFoundException,IOException, SQLException{
		
		final String username;
		final String password;
		final String url;
		
		Properties props = new Properties();
		props.load(new FileReader("/Users/humphreyminott/my_git_repos/1806spark/Banking_Assignment/ExpenseReimbursementProj/src/main/resources/db.properties"));
		
		url = props.getProperty("url");
		password = props.getProperty("password");
		username = props.getProperty("username");
		
		return DriverManager.getConnection(url, username, password);
		
		
	}

}

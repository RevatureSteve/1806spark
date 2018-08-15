package com.revature.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	public static Connection getConnection() throws IOException, SQLException, FileNotFoundException {
		String url;
		String username;
		String password;
		Properties pr = new Properties();
		url =pr.getProperty("url");
		username = pr.getProperty("username");
		password = pr.getProperty("password");
		
		return DriverManager.getConnection(url, username, password);
	}

}

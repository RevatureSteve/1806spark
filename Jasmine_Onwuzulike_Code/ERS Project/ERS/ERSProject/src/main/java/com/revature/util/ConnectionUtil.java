package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	public static Connection getConnection() throws SQLException, IOException, FileNotFoundException{
		String url;
		String username;
		String password;
		
		
		Properties prop = new Properties();
		prop.load(new FileReader("src\\main\\resources\\db.properties"));
		url = prop.getProperty("url");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		
		return DriverManager.getConnection(url, username, password);
	}

}

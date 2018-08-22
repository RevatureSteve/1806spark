package com.revature.ConnectionUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SetConnectionUtil {
	
	
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		
		final String username;
		final String password;
		final String url;
		
		Properties prop = new Properties();
		prop.load(new FileReader ("/RickAndMorty/src/main/resources/db.properties2"));
		
		url=prop.getProperty("url");
		password = prop.getProperty("password");
		username = prop.getProperty("username");
		
		return DriverManager.getConnection(url, username, password);
		
	}

}

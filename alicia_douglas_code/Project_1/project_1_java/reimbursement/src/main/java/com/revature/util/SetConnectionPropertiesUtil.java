package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SetConnectionPropertiesUtil {
	
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		
		final String username;
		final String password;
		final String url;
		
		Properties props = new Properties();
		props.load(new FileReader("src\\main\\resources\\db.properties"));
		
		url = props.getProperty("url");
		username = props.getProperty("username");
		password = props.getProperty("pw");
		return DriverManager.getConnection(url, username, password);
		
	}
}

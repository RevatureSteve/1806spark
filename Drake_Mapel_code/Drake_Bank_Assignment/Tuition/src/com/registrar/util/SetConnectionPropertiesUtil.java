package com.registrar.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SetConnectionPropertiesUtil {
	
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		String username;
		String password;
		String url;
		Properties props = new Properties();
		props.load(new FileReader("src\\resources\\db.properties"));
		
		url = props.getProperty("url");
		username = props.getProperty("username");
		password = props.getProperty("pw");
		
		return DriverManager.getConnection(url, username, password);
		
	}

}

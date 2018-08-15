package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SetConnectionPropertiesUtil {
//the helper methods of the utility class are not specific to the manipulation of pojos
	//Business logic manipulates the POJOs, that's in services
	//this is usually for configuration
	
// let the developer that needs a connection handle these exceptions
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		String username;
		String password;
		String url;
		Properties props = new Properties();
		props.load(new FileReader("src\\main\\resources\\db.properties"));
		
		url = props.getProperty("url");
		username = props.getProperty("username");
		password = props.getProperty("pw");
		
		return DriverManager.getConnection(url, username, password);
	}

}

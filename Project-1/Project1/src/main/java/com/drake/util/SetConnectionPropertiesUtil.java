package com.drake.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SetConnectionPropertiesUtil {

	/*
	 *  utility class helper methods not specific to manipulation of pojos
	 *  	as that would be business logic in services
	 *  usually for configuration 
	 */
	// let the developer that needs a connection handle these exceptions
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // required for Tomcat
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url="jdbc:oracle:thin:@draco.chyyhzvnd3is.us-east-2.rds.amazonaws.com:1521:ORCL";
		String username="project_1";
		String password="p4ssw0rd";
//		Properties props = new Properties();
//		props.load(new FileReader("src\\main\\resources\\db.properties"));
//		
//		url = props.getProperty("url");
//		username = props.getProperty("username");
//		password = props.getProperty("pw");
		
		return DriverManager.getConnection(url, username, password);
		
	}
	
	
	
}
package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SetConnectionPropertiesUtil {
<<<<<<< HEAD

	/*
	 *  utility class helper methods not specific to manipulation of pojos
	 *  	as that would be business logic in services
	 *  usually for configuration 
	 */
	// let the developer that needs a connection handle these exceptions
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		String username;
		String password;
		String url;     
=======
	
	/*
	 * 	utility class helper methods not specific to manipulation of pojos
	 * 		as that would be business logic in services
	 * 	usually for configuration
	 */
	//	let the developer that needs a connection handle these exceptions
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String username = "todo_db";
		String password = "p4ssw0rd";
		String url = "jdbc:oracle:thin:@hearthstone.cxazmpz2rlnm.us-east-2.rds.amazonaws.com:1521:ORCL";
		
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
		Properties props = new Properties();
		props.load(new FileReader("src\\main\\resources\\db.properties"));
		
		url = props.getProperty("url");
		username = props.getProperty("username");
<<<<<<< HEAD
		password = props.getProperty("pw");
		
		return DriverManager.getConnection(url, username, password);
		
	}
	
	
	
=======
		password = props.getProperty("password");
		
		return DriverManager.getConnection(url, username, password);
	}

>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
}

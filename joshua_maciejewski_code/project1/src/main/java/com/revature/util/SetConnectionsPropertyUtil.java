package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SetConnectionsPropertyUtil {
	
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // required for Tomcat
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
//		String url;
//		String username;
//		String password;
//		Properties props = new Properties();
//		props.load(new FileReader("src\\main\\resources\\db.properties"));
		
		String url = "jdbc:oracle:thin:@orcl.csyg1eonp1ik.us-east-2.rds.amazonaws.com:1521:ORCL";
		String username = "project1_db";
		String password = "p4ssw0rd";



		return DriverManager.getConnection(url, username, password);
		
	}

}

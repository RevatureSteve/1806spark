package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProperties {

	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		String username = "er_system";
		String password = "p4ssw0rd";
		String url = "jdbc:oracle:thin:@octowolf.crtsillkaxup.us-east-2.rds.amazonaws.com:1521:ORCL";

//		Properties props = new Properties();
//		props.load(new FileReader("C:\\Users\\eddie_000\\my_git-repos\\1806spark\\JDBC\\Project1\\src\\main\\resources\\db_properties"));
//		url = props.getProperty("url");
//		username = props.getProperty("username");
//		password = props.getProperty("password");

		return DriverManager.getConnection(url, username, password);

	}
}

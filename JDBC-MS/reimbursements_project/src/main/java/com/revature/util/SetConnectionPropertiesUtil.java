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
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url;
		String username;
		String password;
		// Properties props = new Properties();
		// props.load(new FileReader("src\\main\\resources\\db.properties"));
		// url = props.getProperty("url");
		// username = props.getProperty("username");
		// password = props.getProperty("pw");
		url = "jdbc:oracle:thin:@marcin-salamon-oracle.ch2v7k2we1qt.us-east-2.rds.amazonaws.com:1521:ORCL";
		username = "project1_db";
		password = "p4ssw0rd";
		return DriverManager.getConnection(url, username, password);
	}
}

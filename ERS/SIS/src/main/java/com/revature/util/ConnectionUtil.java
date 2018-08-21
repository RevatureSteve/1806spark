package com.revature.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	public static Connection getConnection() throws IOException, SQLException, FileNotFoundException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		String url = "jdbc:oracle:thin:@revaturedatabase.c4iijzopvhom.us-east-2.rds.amazonaws.com:1521:ORCL";
		String username = "reimb_db";
		String password = "p4ssw0rd";
		
		
		return DriverManager.getConnection(url, username, password);
	}

}

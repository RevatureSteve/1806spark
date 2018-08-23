package com.kingsgame.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conn {

	
	public static Connection getConn() throws FileNotFoundException, IOException, SQLException {
		Connection conn = null;
		Properties props = new Properties();
		final String USERNAME;
		final String PASSWORD;
		final String URL;
		
		props.load(new FileReader("/Users/prjctmedia/Desktop/projects/kingsgame/src/main/resources/db.properties"));
		try {
			Class.forName(props.getProperty("driver"));
			URL = props.getProperty("url");
			USERNAME = props.getProperty("username");
			PASSWORD = props.getProperty("password");
			conn = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
			System.out.println("FIX THIS, UNNECESSARY REPETITION OF VARIABLES.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return conn;
	
}
}
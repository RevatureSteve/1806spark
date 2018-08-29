package com.revature.conn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {
	
	private static ConnFactory cf = new ConnFactory();
	
	private ConnFactory()
	{
		super();
	}
	
	public static synchronized ConnFactory getInstance()
	{
		if(cf == null)
		{
			cf = new ConnFactory();
		}
		
		return cf;
	}
	
	public Connection getConnection()
	{
		Connection conn = null;
		//getConnection(url,username,password)
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("URL"), prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return conn;

	}

}

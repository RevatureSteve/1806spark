package com.cpo.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SetConnectionPropertiesUtil {

	/*
	 * utility class helper methods not specific to manipulation of pojos
	 * 		as that would be business logic in services
	 * 	usually for configuration
	 */

	
	
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String username = "";
		String password = "";
		String url = "";
		Properties props = new Properties();
//		props.load(new FileReader("src\\main\\resources\\db.properties"));
		props.load(new FileReader("C:\\Users\\chin2\\mygitrepos\\1806spark\\chinedu_ozodi_code\\todo_project\\PokemonWorldAPI\\src\\main\\resources\\db.properties"));
		url = props.getProperty("url");
		username = props.getProperty("username");
		password = props.getProperty("password");
		
		return DriverManager.getConnection(url,username,password);
	}
}

package com.revature.util;

import java.sql.Connection;
import java.util.Properties;

public class SetConnectionPropertiesUtil {

	/*
	 * utility class helper methods not specific to manipulation of pojos
	 * 		as that would be business logic in services
	 * usually for configuration
	 */
	
	private final static String USERNAME;
	private final static String PASSWORD;
	private final static String URL;
	
	public Connection getConnection() {
		Properties props = new Properties();
		props.load(new FileReader("src\\main\\resources\\db"));
		
		
		return null;
		
	}
}

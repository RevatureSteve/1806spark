/**
 * 
 */
package com.revature.utill;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author sethc
 *
 */
public class SetConnectionPropertiesutil {

	
	/*
	 * 
	 * 
	 * 
	 */
	
	public static Connection getConnection() throws FileNotFoundException, IOException {
		
		Properties props = new Properties();
		props.load(new FileReader("src\\main\\resources\\db.properties") );
		
		
		return null;
		
	}
}

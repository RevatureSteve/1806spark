package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SetConnectionPropertiesUtil {
//the helper methods of the utility class are not specific to the manipulation of pojos
	//Business logic manipulates the POJOs, that's in services
	//this is usually for configuration
	
// let the developer that needs a connection handle these exceptions
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException, ClassNotFoundException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String username = "ers_project";
		String password = "p4ssw0rd";
		String url = "jdbc:oracle:thin:@octocat.ckichuqa168o.us-east-2.rds.amazonaws.com:1521:ORCL";

		
		//String username;
		//String password;
		//String url;
		
		//Properties props = new Properties();
		//props.load(new FileReader("/Users/christopherholmes/my_git_repos/1806spark/chris_holmes_code/src/main/resources/db.properties"));
		//url = props.getProperty("url");
		//username = props.getProperty("username");
		//password = props.getProperty("pw");
		
		return DriverManager.getConnection(url, username, password); //Java key to unlock DB
	}

}


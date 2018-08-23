package com.revature.ConnectionUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SetConnectionUtil {
	
	final static String username = "ers_db";
	final static String password = "p4ssw0rd";
	final static String url = "jdbc:oracle:thin:@masterroshi.cjkgryllidyb.us-east-2.rds.amazonaws.com:1521:ORCL";
	
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException, ClassNotFoundException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
		
		Properties prop = new Properties();
		prop.load(new FileReader ("C:\\Users\\Savii Luciano\\my_git_repos\\1806spark\\Alexander_Hudson_Code\\RickAndMorty\\src\\main\\resources\\db.properties"));
		
		
		
		return DriverManager.getConnection(url, username, password);
		
	}

}

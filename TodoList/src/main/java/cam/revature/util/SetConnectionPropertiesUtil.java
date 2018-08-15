package cam.revature.util;

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
	 * as that would be business logic in services
	 * usually for config
	 */
	
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		
		try {
			Class.forName("ocacle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String username = "todo_db";
		String password = "p4ssw0rd";
		String url = "jdbc:oracle:thin:@gooddata.chd4toccqgaj.us-east-2.rds.amazonaws.com:1521:ORCL"; 
		
//		Properties props = new Properties();
//		props.load(new FileReader("src/main/resources/db.properties"));
		
//		url = props.getProperty("url");
//		username = props.getProperty("username");
//		password = props.getProperty("pw");
		
		return DriverManager.getConnection(url, username, password);
		
	}
}

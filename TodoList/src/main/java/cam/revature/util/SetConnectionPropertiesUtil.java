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
	
	private final static String USERNAME;
	private final static String PASSWORD;
	private final static String URL;
	
	public Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		Properties props = new Properties();
	    props.load(new FileReader("src/main/resources/db.properties"));
		String url = null;
		String username = null;
		String password = null;
		
		url = props.getProperty("url");
		username = props.getProperty("username");
		password = props.getProperty("pw");
		return DriverManager.getConnection(url, username, password);
		
	}
}

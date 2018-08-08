package cam.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cam.revature.domain.User;

public class UserDaoImpl implements UserDao{
	
	private final static String USERNAME = "todo_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@gooddata.chd4toccqgaj.us-east-2.rds.amazonaws.com:1521:ORCL";


	@Override
	public User getUserrByUsername(String username) {
		System.err.println("[LOG] ------ getUserByUser");
		User user = null;
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}

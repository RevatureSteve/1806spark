package cam.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cam.revature.domain.Task;
import cam.revature.domain.User;
import cam.revature.util.SetConnectionPropertiesUtil;

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


	@Override
	public List<Task> getAllTasks() {
		List<Task> tasks = new ArrayList<>();
		try (Connection con = SetConnectionPropertiesUtil.getConnection();){
			String sql = "SELECT * FROM task";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				tasks.add(new Task(rs.getInt("T_ID"), rs.getInt("U_ID"), rs.getString("T_NAME"), rs.getInt("TS_ID"), null));
			}
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tasks;
	}


	@Override
	public List<Task> getTasksByUserId(int id) {
		
		List<Task> tasks = new ArrayList<>();
		try (Connection con = SetConnectionPropertiesUtil.getConnection();){
			String sql = "SELECT * FROM task WHERE u_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()) {
				tasks.add(new Task(rs.getInt("T_ID"), rs.getInt("U_ID"), rs.getString("T_NAME"), rs.getInt("TS_ID"), null));
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

}

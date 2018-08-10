package com.revature.dao;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.domain.Position;
import com.revature.domain.User;
import com.revature.util.DbConnection;

public class UserDaoImpl implements UserDao{

	
	@Override
	public User getUserByEmail(String email) {
		User user=null;
		//What is the method code going to contain? JDBC Code!
		
		try(Connection conn = DbConnection.getConnection()) {
			String sql = "SELECT * FROM users WHERE email= ?";
			PreparedStatement ps = conn.prepareStatement(sql); //pre-compiling the sql statement without the parameter values
			ps.setString(1, email);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()) {
				user = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6));
			}

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public String getUserPositionName(int positionId) {
		Position position = null;
		try(Connection conn = DbConnection.getConnection()) {
		String sql = "SELECT * FROM position WHERE pos_id= ?";
		PreparedStatement ps = conn.prepareStatement(sql); //pre-compiling the sql statement without the parameter values
		ps.setInt(1, positionId);
		ResultSet resultSet = ps.executeQuery();
		if(resultSet.next()) {
			position = new Position(resultSet.getInt(1),resultSet.getString(2));
		}

		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return position.getP_name();
}

	@Override
	public int registerEmployee(User employee) {
		int rowsAffected = 0;
		try(Connection conn = DbConnection.getConnection()) {
			String sql = "INSERT INTO USERS(email,password,fname,lname,position_id) VALUES(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql); //pre-compiling the sql statement without the parameter values
			ps.setString(1, employee.getEmail());
			ps.setString(2, employee.getPassword());
			ps.setString(3, employee.getFname());
			ps.setString(4, employee.getLname());
			ps.setInt(5, employee.getPositionId());
			rowsAffected = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAffected;
	}
	
	
	
	
	
	
	
	

}

package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.domain.Manager;
import com.revature.util.SetConnectionPropertiesUtil;

public class ManagerDaoImpl implements ManagerDao {

	@Override
	public Manager getManagerByEmail(String email) {
		System.err.println("[LOG]---Starting----getUserByUsername() argument: " + email);
		// what is this method code going to contain? JDBC Code
		Manager user = null;
		try(Connection conn = SetConnectionPropertiesUtil.getConnection()){
			System.err.println("[LOG]---inside try/catch----getManagerByEmail() connection to db successful");
			String sql = "SELECT * FROM users WHERE email = ?";
		PreparedStatement ps = 	conn.prepareStatement(sql); // precompiling the SQL statement without the parameter values.
		ps.setString(1, email);
		ResultSet resultSet = ps.executeQuery();
// don't need a loop..username is unique and should only return 1 record or none
		System.err.println("[LOG]---resultSet completed----getManagerByEmail()");
		if(resultSet.next()) {
			System.err.println("[LOG]---resultSet completed----getManagerByEmail() true!");
			user = new Manager(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.err.println("[LOG]---Ending----getManagerByEmail() returning: Manager ");
		return user;
	}

}

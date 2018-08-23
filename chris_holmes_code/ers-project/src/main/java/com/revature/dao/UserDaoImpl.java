package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.revature.domain.Reimbursements;
import com.revature.domain.User;
import com.revature.util.SetConnectionPropertiesUtil;

public class UserDaoImpl implements UserDao{
	
	@Override
	public User getUserbyEmail(String email, String password) { //method to get users by email
		System.err.println("[LOG]--Starting---getUserByEmail() argument:" + email);
		User user = null; //creating a null user object
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()){
			System.err.println("[LOG]---inside try/catch----getUserByEmail() connection to db successful");
			String sql = "SELECT * FROM users WHERE email = ?";
			PreparedStatement ps = conn.prepareStatement(sql); // Precompiles the sql statement without the parameter values
			ps.setString(1, email);
			ResultSet resultSet = ps.executeQuery();
		// we do not need a loop because emails are unique
			System.err.println("[LOG]---resultset completed----getUserByEmail()");
			if(resultSet.next()) {
				if(password.equals(resultSet.getString(3))) {
					user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6));
					System.err.println("[LOG]---resultset if----getUserByEmail() true!");
					System.out.println(user);
					
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}catch (ClassNotFoundException e) {
			
		}
		System.out.println("[LOG]---Ending----getUserByEmail() returning: " + user);
		return user;
	}

	
	
	public Reimbursements createNewReimbursement(int empuId, int amount, String description, Blob image, int rqTypeId, int rqStatusId ) { //method to get users by email
		System.err.println("making reimbursement");
		Reimbursements reimbursement = null; //creating a null reimbursement object
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()){
			System.err.println("2nd connection to db successful");
			String sql = "{call new_reimbursement(?,?,?,NULL,?,?)}";
			CallableStatement cs = conn.prepareCall(sql); // Precompiles the sql statement without the parameter values
			cs.setInt(1,empuId);
			cs.setInt(2,amount);
			cs.setString(3, description);
			//cs.setObject(4, null);
			cs.setInt(4, rqTypeId);
			cs.setInt(5, rqStatusId);
			ResultSet resultSet = cs.executeQuery();
		// we do not need a loop because emails are unique
			System.err.println("[LOG]---resultset completed----getUserByEmail()");
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}catch (ClassNotFoundException e) {
			
		}
		return reimbursement;

	}
	
	
	
	
	
	
	@Override
	public int create(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Object> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}

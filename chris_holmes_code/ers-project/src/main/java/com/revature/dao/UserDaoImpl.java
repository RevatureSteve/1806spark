package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

	
	
	public void createNewReimbursement(int empuId, int amount, String description,  int rqTypeId) { //method to get users by email
		System.out.println("making reimbursement");
		Reimbursements reimbursement = null; //creating a null reimbursement object
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()){
			System.err.println("2nd connection to db successful");
			String sql = "{call new_reimbursement(?,?,?,?)}";
			CallableStatement cs = conn.prepareCall(sql); // Precompiles the sql statement without the parameter values
			cs.setInt(1,empuId);
			System.out.println(empuId);
			cs.setInt(2,amount);
			System.out.println(amount);
			cs.setString(3, description);
			System.out.println(description);
			cs.setInt(4, rqTypeId);
			System.out.println(rqTypeId);
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
		

	}
	
	
	
	public List<Reimbursements> getAllReimbursements() { 
		List<Reimbursements> reimbursement= new ArrayList<Reimbursements>(); //creating a null reimbursement object
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()){
			System.err.println("connection to db successful");
			String sql = "SELECT * FROM reimbursement";
			PreparedStatement ps = conn.prepareStatement(sql); // Precompiles the sql statement without the parameter values
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				reimbursement.add(new Reimbursements(resultSet.getInt("emp_u_id"), resultSet.getInt("mgr_u_id"), resultSet.getInt("amt"), resultSet.getString("description"), null, resultSet.getTimestamp("timesubmission"), resultSet.getInt("rq_type_id"), resultSet.getInt("rq_status_id"), resultSet.getInt("r_id")));
				
			}
			
			System.err.println("[LOG]---resultset completed");
			
					System.out.println(reimbursement);
					
		
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}catch (ClassNotFoundException e) {
			
		}
		System.out.println("[LOG]---Ending----returning: " + reimbursement);
		return reimbursement;
	}
	
	@Override
	public int updateUser(User u) {
		int rowsChanged = 0;
		try(Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "UPDATE users SET EMAIL = ?, PASSWORD = ?, F_NAME = ?, L_NAME = ?  WHERE u_id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getfName());
			ps.setString(4, u.getlName());
			ps.setInt(5, u.getuId());
			rowsChanged = ps.executeUpdate();
		
		}catch (Exception e) {
			e.printStackTrace();
		}return rowsChanged;
	}
	
	@Override
	public int updateReimbursement(Reimbursements r) {
		int rowsChanged = 0;
		try(Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "UPDATE REIMBURSEMENT SET rq_status_id = ? WHERE r_id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getRq_status_id());
			ps.setInt(2, r.getR_id());
		
			rowsChanged = ps.executeUpdate();
		
		}catch (Exception e) {
			e.printStackTrace();
		}return rowsChanged;
	}



	@Override
	public int create(User obj) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public List<Object> read() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

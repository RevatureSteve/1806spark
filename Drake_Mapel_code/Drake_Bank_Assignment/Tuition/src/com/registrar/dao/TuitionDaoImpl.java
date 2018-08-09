package com.registrar.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.registrar.pojo.Account;
import com.registrar.pojo.User;
import com.registrar.util.SetConnectionPropertiesUtil;

public class TuitionDaoImpl implements TuitionDao {
	
	@Override
	public void createUserProc(User u) {
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "{CALL insert_u_procedure(?, ?, ?, ?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, u.getUsername());
			cs.setString(2, u.getPassword());
			cs.setString(3, u.getFname());
			cs.setString(4, u.getLname());
			
			cs.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	@Override
	public void createStudentAccountProc(Account ac) {
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "{CALL insert_ac_procedure(?, ?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setDouble(1, ac.getBalance());
			cs.setInt(2, ac.getUsers_id());
			
			cs.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	@Override
	public User getUserByUsername(String username) {

		User user = null;
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet resultSet = ps.executeQuery();

			if(resultSet.next()) {
				user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return user;
	}
	
	@Override
	public void viewBalance(int userId) {
		
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "SELECT * FROM student_account WHERE users_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet resultSet = ps.executeQuery();

			if(resultSet.next()) {
				System.out.println(resultSet.getInt(2));
			} else System.out.println("must create an account to view account");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	@Override
	public void addClass(int userId) {
		
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "UPDATE Student_Account SET balance = (balance + 1500) WHERE users_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("one class added");
		
	}
	
	@Override
	public void dropClasses(int d, int u_id) {
		
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "UPDATE Student_Account SET balance = (balance - (1500 * ?)) WHERE users_id = ?";
			String sqlCheck = "SELECT balance FROM Student_Account WHERE users_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			PreparedStatement psCheck = conn.prepareStatement(sqlCheck);
			psCheck.setInt(1, u_id);
			ResultSet rs = psCheck.executeQuery();
			if (rs.next() && d <= (rs.getInt(1) / 1500)) {
				ps.setInt(1, d);
				ps.setInt(2, u_id);
				ps.execute();
			} else {
				System.out.println("you do not have that many classes");
				d = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("" + d + " class(es) dropped");
		
	}

}

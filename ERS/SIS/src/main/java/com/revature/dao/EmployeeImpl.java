package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;
import com.revature.util.ConnectionUtil;

public class EmployeeImpl implements EmpDao{

	
	// Get the information for an Employee.
	@Override
	public Users login(String email, String password) {
		Users usr = null;
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				usr = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(6));
				
			}
			else {
				System.out.println("Need some validation here");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return usr;
	}

	// Get all reimbursements for each Employee.
	@Override
	public List<Reimbursement> getEmpReimb(int empId) {
		Reimbursement rb = null;
		List<Reimbursement> users = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM reimbursement LEFT JOIN rq_status ON reimbursement.rq_status_id = rq_status.rq_status_id LEFT JOIN users ON reimbursement.emp_u_id = users.u_id LEFT JOIN rq_type ON reimbursement.rq_type_id = rq_type.rq_type_id WHERE emp_u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rb = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(18), rs.getString(4),rs.getString(10), rs.getString(12), rs.getString(13));
				users.add(rb);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return users;
	}

	@Override
	public int createNewReimbursement(double amount, String rDescription, int uId, String type) {
		
		int row = 0;
		try(Connection conn = ConnectionUtil.getConnection()) {
		String sql = "INSERT INTO reimbursement (amount, r_description, emp_id) VALUES(?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, amount);
		ps.setString(2, rDescription);
		ps.setInt(3, uId);
		row = ps.executeUpdate();
		System.out.println(row + " employees added");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return row;
		
	}
	
	
	

	}

	

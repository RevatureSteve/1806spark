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
	public Users getEmpInfo(String email, String password) {
		Users usr = null;
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT u_id, f_name, l_name FROM users WHERE email = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				usr = new Users(rs.getInt(1), rs.getString(2), rs.getString(3));
				
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
	public List<Reimbursement> getAllReimb(int empId) {
		Reimbursement rb = null;
		List<Reimbursement> users = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT r_id, r_description, time_submitted, amount FROM reimbursement WHERE emp_u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rb = new Reimbursement(rs.getInt(1), rs.getDouble(4), rs.getString(2), rs.getString(3));
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
		//Get status of an reimbursement
		public String getReimbursementStatus(int r_id) {
			
			
			
			
			return null;
			
			
			
		}
	
	

	}

	

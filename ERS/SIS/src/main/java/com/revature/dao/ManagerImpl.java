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

import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;
import com.revature.util.ConnectionUtil;

public class ManagerImpl implements MangDao{

	
	//Get the information of the Manager.
	@Override
	public Users getMangInfo(String email, String password) {
		Users usr = null;
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT f_name, l_name FROM users WHERE email = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				 usr = new Users(rs.getString(1), rs.getString(2));
				
			}
			else {
				System.out.println("You are not M!");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Something went wrong here");
		} catch (SQLException e) {
			System.out.println("Something went wrong here");
		} catch (IOException e) {
			System.out.println("Something went wrong here");
		}
		return usr;
	}

	
	//Gets all the employees.
	@Override
	public List<Users> getEmployees() {
		Users usr = null;
		List<Users> emp = new ArrayList<Users>();
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				usr = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(6));
				emp.add(usr);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return emp;
	}

	
	//Gets all the reimbursements.
	@Override
	public List<Reimbursement> getAllReimb() {
		List<Reimbursement> rbs = new ArrayList<Reimbursement>();
		Reimbursement rb = null;
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM reimbursement LEFT JOIN rq_status ON reimbursement.rq_status_id = rq_status.rq_status_id LEFT JOIN users ON reimbursement.emp_u_id = users.u_id LEFT JOIN rq_type ON reimbursement.rq_type_id = rq_type.rq_type_id";
			
			//String sql = "SELECT * FROM reimbursement LEFT JOIN rq_status ON reimbursement.rq_status_id = rq_status.rq_status_id LEFT JOIN users ON reimbursement.emp_u_id = users.u_id";
PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				rb = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(18), rs.getString(4),rs.getString(10), rs.getString(12), rs.getString(13));
				rbs.add(rb);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rbs;
	}

	
	//Allows a manger to add a new employee.
	@Override
	public void newEmployee(Users usr) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "{ call new_emp(?,?,?,?,?,?) }";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, usr.getEmpId());
			cs.setString(2, usr.getFirstname());
			cs.setString(3, usr.getLastname());
			cs.setString(4, usr.getEmail());
			cs.setString(5, usr.getPassword());
			cs.setInt(6, usr.getPositionId());
			int num = cs.executeUpdate();
			System.out.println(num + " agents have been added.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}

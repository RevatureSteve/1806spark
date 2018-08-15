package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
				System.out.println("You are not M!");
			}
			else {
				 usr = new Users(rs.getString(1), rs.getString(2));
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
	public ArrayList<Users> getEmpInfo(Users usr) {
		ArrayList<Users> emp = new ArrayList<Users>();
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT emp_u_id, f_name, l_name FROM users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				usr = new Users(rs.getInt(1), rs.getString(2), rs.getString(3));
				emp.add(usr);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	//Gets all the reimbursements.
	@Override
	public ArrayList<Reimbursement> getAllEmpReimb() {
		try(Connection conn = ConnectionUtil.getConnection()) {} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	//Allows a manger to add a new eimployee.
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}

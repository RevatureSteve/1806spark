package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionProperties;


public class ErsDaoImpl implements ErsDao {

	// CREATE
	public void submitReimbursementRequest(int emp_u_id, int mgr_u_id, Double amount, String description, String img, int rq_type_id) {
		
		try (Connection conn = ConnectionProperties.getConnection();) {
			
			String partial = "(emp_u_id, mgr_u_id, amount, description, img, rq_type_id)";
			String sql = "INSERT INTO reimbursement " + partial + " VALUES(?, ?, ?, ?, ?, ?)";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, emp_u_id);
			cs.setInt(2, mgr_u_id);
			cs.setDouble(3, amount);
			cs.setString(4, description);
			cs.setString(5, img);
			cs.setInt(6, rq_type_id);
			
			ResultSet rs = cs.executeQuery();
			System.out.println(rs);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// READ
	public void viewPendingRequests() {

		try (Connection conn = ConnectionProperties.getConnection();) {

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

	}

	public void viewResolvedRequests() {
		
		try (Connection conn = ConnectionProperties.getConnection();) {

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

	}

	public void viewProfile() {
		
		try (Connection conn = ConnectionProperties.getConnection();) {

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

	}

	public void viewAllPendingRequests() {
		
		try (Connection conn = ConnectionProperties.getConnection();) {

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

	}

	public void viewAllResolvedRequests() {
		
		try (Connection conn = ConnectionProperties.getConnection();) {

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

	}

	public void viewAllEmployees() {
		
		try (Connection conn = ConnectionProperties.getConnection();) {

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

	}

	public void viewReimbursementRequestById() {
		
		try (Connection conn = ConnectionProperties.getConnection();) {

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

	}

	// UPDATE
	public void updateProfile() {
		
		try (Connection conn = ConnectionProperties.getConnection();) {

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

	}

	public void managePendingRequests() {
		
		try (Connection conn = ConnectionProperties.getConnection();) {

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

	}

	// DELETE

}

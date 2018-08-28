package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pogo.Reimbursement;
import com.revature.pogo.Users;
import com.revature.util.ConnectionProperties;


public class ErsDaoImpl implements ErsDao {

	// CREATE
	//Employee Cases------------------------------
	public void submitReimbursementRequest(int emp_u_id, Double amount, String description, String img, int rq_type_id) {
		
		try (Connection conn = ConnectionProperties.getConnection();) {
			
			String partial = "(emp_u_id, amount, description, img, rq_type_id)";
			String sql = "INSERT INTO reimbursement " + partial + " VALUES(?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, emp_u_id);
			ps.setDouble(2, amount);
			ps.setString(3, description);
			ps.setString(4, img);
			ps.setInt(5, rq_type_id);
			
			int rowsAffected = ps.executeUpdate();			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	//Manager Cases------------------------------

	// READ
	//Employee Cases------------------------------
	public Users login(String email, String password) {
		
		Users user = null;
		
		try (Connection conn = ConnectionProperties.getConnection();) {
			
			String sql = "SELECT * FROM users WHERE email = ? AND pass_word = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
	
			if (rs.next()) {
				user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public List<Reimbursement> viewUserPendingRequests(int uId) {

		List<Reimbursement> requests = new ArrayList<>();
		
		try (Connection conn = ConnectionProperties.getConnection();) {
			
				String sql = "SELECT * FROM reimbursement WHERE emp_u_id = " + uId + " AND rq_status_id = 1";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					Reimbursement rb = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
					requests.add(rb);
				}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return requests;
	}

	public List<Reimbursement> viewUserResolvedRequests(int uId) {
		
		List<Reimbursement> requests = new ArrayList<>();
		
		try (Connection conn = ConnectionProperties.getConnection();) {

			String sql = "SELECT * FROM reimbursement WHERE emp_u_id = " + uId + " AND rq_status_id = 2 OR rq_status_id = 3";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Reimbursement rb = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
				requests.add(rb);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return requests;
	}

	public Users viewProfile(int uId) {
		
		Users user = null;
		
		try (Connection conn = ConnectionProperties.getConnection();) {
			
			String sql = "SELECT * FROM users WHERE u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uId);
			ResultSet rs = ps.executeQuery();
	
			if (rs.next()) {
				user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	//Manager Cases------------------------------
	public List<Reimbursement> viewAllPendingRequests() {
		
		List<Reimbursement> requests = new ArrayList<>();
		
		try (Connection conn = ConnectionProperties.getConnection();) {
			
			String sql = "SELECT * FROM reimbursement WHERE rq_status_id = 1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Reimbursement rb = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
				requests.add(rb);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return requests;
	}

	public List<Reimbursement> viewAllResolvedRequests() {
		
		List<Reimbursement> requests = new ArrayList<>();
		
		try (Connection conn = ConnectionProperties.getConnection();) {
			
			String sql = "SELECT * FROM reimbursement WHERE rq_status_id = 2 OR rq_status_id = 3";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Reimbursement rb = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
				requests.add(rb);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return requests;
	}

	public List<Users> viewAllEmployees() {
		
		List<Users> users = new ArrayList<>();
		
		try (Connection conn = ConnectionProperties.getConnection();) {
			
			String sql = "SELECT * FROM users WHERE pos_id = 2";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Users us = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
				users.add(us);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public List<Reimbursement> viewAllReimbursementRequestById(int uId) {
		
		List<Reimbursement> requests = new ArrayList<>();
		
		try (Connection conn = ConnectionProperties.getConnection();) {
			
			String sql = "SELECT * FROM reimbursement WHERE emp_u_id = " + uId;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Reimbursement rb = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
				requests.add(rb);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return requests;
	}

	// UPDATE
	//Employee Cases------------------------------
	public void updateProfile(Users user) {
		
		try (Connection conn = ConnectionProperties.getConnection();) {
			
			String sql = "UPDATE users SET email = ?, pass_word = ?, fname = ?, lname = ? WHERE u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstname());
			ps.setString(4, user.getLastname());
			ps.setInt(5, user.getuId());
			
			int rowsAffected = ps.executeUpdate();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	//Manager Cases------------------------------
	public void managePendingRequests(Users user, Reimbursement reimb) {
		
		try (Connection conn = ConnectionProperties.getConnection();) {
			
			String sql = "UPDATE reimbursement SET mgr_u_id = ?, rq_status_id = ? WHERE r_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getuId());
			ps.setInt(2, reimb.getReqStatusId());
			ps.setInt(3, reimb.getReimbursementId());
			
			int rowsAffected = ps.executeUpdate();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// DELETE
	//Employee Cases------------------------------
	//Manager Cases------------------------------

}

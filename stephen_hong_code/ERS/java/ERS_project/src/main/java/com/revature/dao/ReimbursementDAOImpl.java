package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.util.ConnectionFactory;
import com.revature.util.SetConnectionPropertiesUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	@Override
	public Reimbursement createReimbursement(Reimbursement r) {
		try(Connection conn = SetConnectionPropertiesUtil.getConnection()){
			String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES (?,?,?,?,?,?,?)";
			String[] keys = {"reimb_id"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			//pre-compiling SQL statement
			ps.setDouble(1, r.getAmount());
			ps.setTimestamp(2, r.getTimeSubmitted());
			ps.setString(3, r.getDescription());
			ps.setInt(4, r.getAuthor());
			ps.setInt(5, 21);
			ps.setInt(6, r.getStatus());
			ps.setInt(7, r.getType());
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			while(rs.next()) {
				r.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return r;
	}

	@Override
	public ArrayList<Reimbursement> getAllReimbursements() {
		ArrayList<Reimbursement> results = new ArrayList<>();
		try(Connection conn = SetConnectionPropertiesUtil.getConnection()){
			String sql = "SELECT * FROM ers_reimbursement";
			PreparedStatement ps = conn.prepareStatement(sql);
			//pre-compiling SQL statement without the parameter values
			ResultSet rs = ps.executeQuery(sql);
			//Use ResultSet and executeQuery for SELECT
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setId(rs.getInt("reimb_id"));
				temp.setAmount(rs.getDouble("reimb_amount"));
				temp.setTimeSubmitted(rs.getTimestamp("reimb_submitted"));
				temp.setTimeResolved(rs.getTimestamp("reimb_resolved"));
				temp.setDescription(rs.getString("reimb_description"));
				temp.setReceipt(rs.getBlob("reimb_receipt"));
				temp.setAuthor(rs.getInt("reimb_author"));
				temp.setResolver(rs.getInt("reimb_resolver"));
				temp.setStatus(rs.getInt("reimb_status_id"));
				temp.setType(rs.getInt("reimb_type_id"));
				
				results.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return results;
	}

	@Override
	public ArrayList<Reimbursement> getReimbursementsForUserId(int userID) {
		ArrayList<Reimbursement> results = new ArrayList<>();
		try(Connection conn = SetConnectionPropertiesUtil.getConnection()){
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			//pre-compiling SQL statement
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
			//Use ResultSet and executeQuery for SELECT
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setId(rs.getInt("reimb_id"));
				temp.setAmount(rs.getDouble("reimb_amount"));
				temp.setTimeSubmitted(rs.getTimestamp("reimb_submitted"));
				temp.setTimeResolved(rs.getTimestamp("reimb_resolved"));
				temp.setDescription(rs.getString("reimb_description"));
				temp.setReceipt(rs.getBlob("reimb_receipt"));
				temp.setAuthor(rs.getInt("reimb_author"));
				temp.setResolver(rs.getInt("reimb_resolver"));
				temp.setStatus(rs.getInt("reimb_status_id"));
				temp.setType(rs.getInt("reimb_type_id"));
				results.add(temp);
			}//loop through and select users from the table and add them to the list
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return results;
	}

	@Override
	public Reimbursement updateReimbursement(Reimbursement r) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "UPDATE ers_reimbursement SET reimb_resolved=?, reimb_receipt=?, reimb_resolver=?, reimb_status_id=? WHERE reimb_id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setTimestamp(1, r.getTimeResolved());
			ps.setBlob(2, r.getReceipt());
			ps.setInt(3, r.getResolver());
			ps.setInt(4, r.getStatus());
			ps.setInt(5, r.getId());
			
			int rowsAffected = ps.executeUpdate();
			
			if(rowsAffected > 0)
				return r;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
		Reimbursement r = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			//pre-compiling SQL statement
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			//Use ResultSet and executeQuery for SELECT
			if(rs.next()) {
				r = new Reimbursement();
				r.setId(rs.getInt(1));
				r.setAmount(rs.getDouble(2));
				r.setTimeSubmitted(rs.getTimestamp(3));
				r.setTimeResolved(rs.getTimestamp(4));
				r.setDescription(rs.getString(5));
				r.setReceipt(rs.getBlob(6));
				r.setAuthor(rs.getInt(7));
				r.setResolver(rs.getInt(8));
				r.setStatus(rs.getInt(9));
				r.setType(rs.getInt(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return r;
	}

}

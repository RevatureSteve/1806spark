package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Reimbursement;
import com.revature.util.SetConnectionPropertiesUtil;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;

public class ReimbursementDao {

	// Create
	public void createReimbursement(Reimbursement reimb) {
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			String sql = "{Call create_reimbursement(?,?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, reimb.getEmpUId());
			cs.setDouble(2, reimb.getAmt());
			cs.setString(3, reimb.getDescription());
			cs.setBlob(4, reimb.getImg());
			cs.setInt(5, reimb.getRbTypeId());
			cs.executeQuery();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	// Read
	/**
	 * get a list of reimbursements using the employees id number
	 * 
	 * @param id
	 * @return
	 */
	public List<Reimbursement> getReimbursementByEmployeeId(int id) {
		List<Reimbursement> reimbursements = new ArrayList<>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			String sql = "{call get_reimbursements_by_emp_id(?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, id);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.executeQuery();
			ResultSet rs = (ResultSet) cs.getObject(2);
			while (rs.next()) {
				Reimbursement reimbursement = new Reimbursement(rs.getInt(1), rs.getInt("emp_u_id"),
						rs.getInt("mgr_u_id"), rs.getDouble("amt"), rs.getString("description"), rs.getBlob("img"),
						rs.getDate("time_submission"), rs.getString("rb_type"), rs.getString("rb_status"));
				reimbursements.add(reimbursement);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	/**
	 * get a list of all the reimbursements
	 * 
	 * @return
	 */
	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> reimbursements = new ArrayList<>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			String sql = "{call get_reimbursements(?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.executeQuery();
			ResultSet rs = (ResultSet) cs.getObject(1);
			while (rs.next()) {
				Reimbursement reimbursement = new Reimbursement(rs.getInt(1), rs.getInt("emp_u_id"),
						rs.getInt("mgr_u_id"), rs.getDouble("amt"), rs.getString("description"), rs.getBlob("img"),
						rs.getDate("time_submission"), rs.getString("rb_type"), rs.getString("rb_status"));
				reimbursements.add(reimbursement);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	// Update
	/**
	 * update the status of a reimbursement
	 * 
	 * @param reimb
	 * @param mgrId
	 * @param status
	 */
	public void updateReimbursementStatus(Reimbursement reimb, int mgrId, int status) {
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			String sql = "UPDATE reimbursement SET mgr_u_id = ? , rb_status_id = ? WHERE r_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mgrId);
			ps.setInt(2, status);
			ps.setInt(3, reimb.getrId());
			ps.executeQuery();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	// Delete

}

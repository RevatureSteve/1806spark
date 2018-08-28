package com.cpo.doa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cpo.model.Reimbursement;
import com.cpo.util.SetConnectionPropertiesUtil;

public class ReimbursementDatabaseDao implements ReimbursementDao {

	@Override
	public int createReimbursement(Reimbursement reimb) {
		int ra = 0;
		// Going to contain code for JDBC
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

			String sql = "INSERT INTO reimbursement (emp_u_id,mgr_u_id,amt,description,img,timesubmission,rq_type_id,rq_status_id) VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimb.getEmpUId());
			ps.setString(2, null);
			ps.setInt(3, reimb.getAmt());
			ps.setString(4, reimb.getDescription());
			ps.setBlob(5, reimb.getImg());
			ps.setTimestamp(6, reimb.getTimeSubmission());
			ps.setInt(7, reimb.getRqTypeId());
			ps.setInt(8, 1);
			ra = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ra;
	}
	
	@Override
	public int createRequestType(int id, String name) {
		// Going to contain code for JDBC
		int rt = 0;
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			String sql = "INSERT INTO rq_type VALUES ( ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			rt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return rt;
	}

	// --------READ----------
	@Override
	public List<Reimbursement> getAllReimbursements() {
		// Going to contain code for JDBC
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

			String sql = "SELECT * FROM reimbursement r "
					+ "RIGHT OUTER JOIN rq_status rs ON (r.rq_status_id = rs.rq_status_id) "
					+ "JOIN rq_type rt ON (r.rq_type_id = rt.rq_type_id)\r\n" + 
					"JOIN users u ON (r.emp_u_id = u.u_id) "
					+ "LEFT OUTER JOIN users m ON (r.mgr_u_id = m.u_id) ORDER BY r.rq_status_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reimbursement reimb = new Reimbursement(rs.getInt("r_id"), rs.getInt("emp_u_id"), rs.getInt("mgr_u_id"),
						rs.getInt("amt"), rs.getString("description"), rs.getBlob("img"),
						rs.getTimestamp("timesubmission"), rs.getInt("rq_type_id"), rs.getString("rq_type"),
						rs.getInt("rq_status_id"), rs.getString("rq_status"),rs.getString("fname"),rs.getString("lname"),rs.getString("fname"),rs.getString("lname"));
				reimbs.add(reimb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return reimbs;
	}
	
	@Override
	public List<Reimbursement> getReimbursementsByUId(int id) {
		// Going to contain code for JDBC
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

			String sql = "SELECT * FROM reimbursement r "
					+ "RIGHT OUTER JOIN rq_status rs ON (r.rq_status_id = rs.rq_status_id) "
					+ "JOIN rq_type rt ON (r.rq_type_id = rt.rq_type_id) " 
					+ "JOIN users u ON (r.emp_u_id = u.u_id) "
					+ "LEFT OUTER JOIN users m ON (r.mgr_u_id = m.u_id)"
					+ " WHERE emp_u_id = ? ORDER BY r.rq_status_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reimbursement reimb = new Reimbursement(rs.getInt("r_id"), rs.getInt("emp_u_id"), rs.getInt("mgr_u_id"),
						rs.getInt("amt"), rs.getString("description"), rs.getBlob("img"),
						rs.getTimestamp("timesubmission"), rs.getInt("rq_type_id"), rs.getString("rq_type"),
						rs.getInt("rq_status_id"), rs.getString("rq_status"),
						rs.getString("fname"),rs.getString("lname"),
						rs.getString("fname"),rs.getString("lname"));
				reimbs.add(reimb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return reimbs;
	}
	@Override
	public int getRequestType(int id) {
		// Going to contain code for JDBC
		int rt = 0;
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			String sql = "SELECT rq_type_id FROM rq_type WHERE rq_type_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				rt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return rt;
	}
	
	//------UPDATE----------
	@Override
	public int updateRequestType(int id, String name) {
		// Going to contain code for JDBC
		int rt = 0;
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			String sql = "UPDATE rq_type SET rq_type = ? WHERE rq_type_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, id);
			rt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return rt;
	}
	
	@Override
	public int updateReimbursement(Reimbursement reimb) {
		int ra = 0;
		// Going to contain code for JDBC
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

			String sql = "UPDATE reimbursement SET rq_status_id = ? WHERE r_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimb.getRqStatusId());
			ps.setInt(2, reimb.getrId());
			ra = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ra;
	}
	

}

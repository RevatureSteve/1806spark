package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Reimbursement;
import com.revature.domain.User;
import com.revature.util.SetConnectionPropertiesUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {

	@Override
	public List<Reimbursement> getAllReimbursements() {
		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()) {
			String sql = "SELECT * FROM reimbursement INNER JOIN users ON users.u_id = reimbursement.emp_u_id \r\n"
					+ "    INNER JOIN position ON position.pos_id = users.pos_id \r\n"
					+ "    INNER JOIN rq_type ON rq_type.rq_type_id = reimbursement.rq_type_id\r\n"
					+ "    INNER JOIN rq_status ON rq_status.rq_status_id = reimbursement.rq_status_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt("r_u_id"), rs.getInt("emp_u_id"), rs.getInt("mgr_u_id"),
						rs.getInt("amount"), rs.getString("description"), rs.getObject("img"),
						rs.getString("timesubmission"), rs.getString("rq_type"), rs.getString("rq_style"),
						rs.getInt("rq_type_id"), rs.getInt("rq_status_id")));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return reimbursements;

	}

	@Override
	public List<Reimbursement> getAllPendingReimbursements() {
		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()) {
			String sql = "SELECT * FROM reimbursement INNER JOIN users ON users.u_id = reimbursement.emp_u_id \r\n"
					+ "    INNER JOIN position ON position.pos_id = users.pos_id \r\n"
					+ "    INNER JOIN rq_type ON rq_type.rq_type_id = reimbursement.rq_type_id\r\n"
					+ "    INNER JOIN rq_status ON rq_status.rq_status_id = reimbursement.rq_status_id "
					+ "WHERE rq_status_id = 1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt("r_id"), rs.getInt("emp_u_id"), rs.getInt("mgr_u_id"),
						rs.getInt("amount"), rs.getString("description"), rs.getObject("img"),
						rs.getString("timesubmission"), rs.getString("rq_type"), rs.getString("rq_status"),
						rs.getInt("rq_type_id"), rs.getInt("rq_status_id")));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getReimbusementsByUser(int uid) {
		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()) {
			String sql = "SELECT * FROM reimbursement INNER JOIN users ON users.u_id = reimbursement.emp_u_id \r\n"
					+ "    INNER JOIN position ON position.pos_id = users.pos_id \r\n"
					+ "    INNER JOIN rq_type ON rq_type.rq_type_id = reimbursement.rq_type_id\r\n"
					+ "    INNER JOIN rq_status ON rq_status.rq_status_id = reimbursement.rq_status_id"
					+ " WHERE users.u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt("r_u_id"), rs.getInt("emp_u_id"), rs.getInt("mgr_u_id"),
						rs.getInt("amount"), rs.getString("description"), rs.getObject("img"),
						rs.getString("timesubmission"), rs.getString("rq_type"), rs.getString("rq_style"),
						rs.getInt("rq_type_id"), rs.getInt("rq_status_id")));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return reimbursements;
	}

	@Override
	public int addNewReimbursement(Reimbursement reim) {
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()) {
			String sql = "{call insert_reimbursement(?,?,?,?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, reim.getEmpUId());
			cs.setInt(2, reim.getAmount());
			cs.setString(3, reim.getDescription());
			cs.setInt(4, reim.getRq_typeId());
			cs.setInt(5, reim.getRq_statusId());
			return cs.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public List<Reimbursement> getPendingReimbusementsByUser(int id) {
		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()) {
			String sql = "SELECT * FROM reimbursement INNER JOIN users ON users.u_id = reimbursement.emp_u_id\r\n" + 
					"					INNER JOIN position ON position.pos_id = users.pos_id\r\n" + 
					"					INNER JOIN rq_type ON rq_type.rq_type_id = reimbursement.rq_type_id\r\n" + 
					"					INNER JOIN rq_status ON rq_status.rq_status_id = reimbursement.rq_status_id\r\n" + 
					"					WHERE users.u_id = ? AND reimbursement.rq_status_id = 1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt("r_id"), rs.getInt("emp_u_id"), rs.getInt("mgr_u_id"),
						rs.getInt("amount"), rs.getString("description"), rs.getObject("img"),
						rs.getString("timesubmission"), rs.getString("rq_type"), rs.getString("rq_status"),
						rs.getInt("rq_type_id"), rs.getInt("rq_status_id")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reimbursements;

	}

	@Override
	public List<Reimbursement> getResolvedReimbusementsByUser(int id) {
		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()) {
			String sql = "SELECT * FROM reimbursement INNER JOIN users ON users.u_id = reimbursement.emp_u_id\r\n" + 
					"					INNER JOIN position ON position.pos_id = users.pos_id\r\n" + 
					"					INNER JOIN rq_type ON rq_type.rq_type_id = reimbursement.rq_type_id\r\n" + 
					"					INNER JOIN rq_status ON rq_status.rq_status_id = reimbursement.rq_status_id\r\n" + 
					"					WHERE users.u_id = ? AND reimbursement.rq_status_id != 1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt("r_id"), rs.getInt("emp_u_id"), rs.getInt("mgr_u_id"),
						rs.getInt("amount"), rs.getString("description"), rs.getObject("img"),
						rs.getString("timesubmission"), rs.getString("rq_type"), rs.getString("rq_status"),
						rs.getInt("rq_type_id"), rs.getInt("rq_status_id")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reimbursements;
	}

}

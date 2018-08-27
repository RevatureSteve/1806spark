package com.revature.dao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Reimbursement;
import com.revature.pojo.Type;
import com.revature.util.SetConnectionPropertiesUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {

	@Override
	public List<Reimbursement> getAllReimbursements() {

		List<Reimbursement> list = new ArrayList<>();

		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			String sql = "SELECT r.r_id, r.r_resolved_id, r.r_submission_id, r.amount, r.description, r.img, r.time_submission, r.rq_type_id,\r\n"
					+ "r.rq_status_id, uu.fname AS rb_resolved_fname, uu.lname AS rb_resolved_lname, u.fname AS rb_submission_fname, u.lname AS\r\n"
					+ "rb_submission_lname, rq.rq_type ,s.rq_status \r\n" + "from reimbursement r\r\n"
					+ "INNER JOIN rq_type rq ON rq.rq_type_id = r.rq_type_id\r\n"
					+ "INNER JOIN users u ON u.u_id = r.r_submission_id\r\n"
					+ "LEFT OUTER JOIN users uu ON uu.u_id = r.r_resolved_id\r\n"
					+ "INNER JOIN rq_status s ON r.rq_status_id = s.rq_status_id\r\n" + "WHERE r.rq_status_id = 1";

			PreparedStatement ps = conn.prepareStatement(sql);
			Blob b = conn.createBlob();
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Reimbursement(rs.getInt("r_id"), rs.getInt("r_resolved_id"), rs.getInt("r_submission_id"),
						rs.getDouble("amount"), rs.getString("description"), rs.getBytes("img"),
						rs.getString("time_submission"), rs.getInt("rq_type_id"), rs.getInt("rq_status_id"),
						rs.getString("rb_resolved_fname"), rs.getString("rb_resolved_lname"),
						rs.getString("rb_submission_fname"), rs.getString("rb_submission_lname"),
						rs.getString("rq_type"), rs.getString("rq_status")));
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void createNewReimbursement(int uId, double amt, String desc, byte[] img, int typeId) {

		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			String sql = "{call new_reimbursement(?,?,?,?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			Blob b = conn.createBlob();
			b.setBytes(1, img);
			cs.setInt(1, uId);
			cs.setDouble(2, amt);
			cs.setString(3, desc);
			cs.setBlob(4, b);
			cs.setInt(5, typeId);
			cs.executeQuery();

		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Reimbursement> getReimbursementById(int id) {

		List<Reimbursement> rb = new ArrayList<>();

		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

			String sql = "SELECT r.r_id, r.r_resolved_id, r.r_submission_id, r.amount, r.description, r.img, r.time_submission, r.rq_type_id,\r\n"
					+ "r.rq_status_id, uu.fname AS rb_resolved_fname, uu.lname AS rb_resolved_lname, u.fname AS rb_submission_fname, u.lname AS\r\n"
					+ "rb_submission_lname, rq.rq_type ,s.rq_status \r\n" + "from reimbursement r\r\n"
					+ "INNER JOIN rq_type rq ON rq.rq_type_id = r.rq_type_id\r\n"
					+ "INNER JOIN users u ON u.u_id = r.r_submission_id\r\n"
					+ "LEFT OUTER JOIN users uu ON uu.u_id = r.r_resolved_id\r\n"
					+ "INNER JOIN rq_status s ON r.rq_status_id = s.rq_status_id\r\n" + "WHERE r.r_submission_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				rb.add(new Reimbursement(rs.getInt("r_id"), rs.getInt("r_resolved_id"), rs.getInt("r_submission_id"),
						rs.getDouble("amount"), rs.getString("description"), rs.getBytes("img"),
						rs.getString("time_submission"), rs.getInt("rq_type_id"), rs.getInt("rq_status_id"),
						rs.getString("rb_resolved_fname"), rs.getString("rb_resolved_lname"),
						rs.getString("rb_submission_fname"), rs.getString("rb_submission_lname"),
						rs.getString("rq_type"), rs.getString("rq_status")));
			}

		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rb;
	}

	@Override
	public List<Reimbursement> getResolvedReimbursements() {

		List<Reimbursement> rb = new ArrayList<>();

		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

			String sql = "SELECT r.r_id, r.r_resolved_id, r.r_submission_id, r.amount, r.description, r.img, r.time_submission, r.rq_type_id,\r\n"
					+ "r.rq_status_id, uu.fname AS rb_resolved_fname, uu.lname AS rb_resolved_lname, u.fname AS rb_submission_fname, u.lname AS\r\n"
					+ "rb_submission_lname, rq.rq_type ,s.rq_status \r\n" + "from reimbursement r\r\n"
					+ "INNER JOIN rq_type rq ON rq.rq_type_id = r.rq_type_id\r\n"
					+ "INNER JOIN users u ON u.u_id = r.r_submission_id\r\n"
					+ "LEFT OUTER JOIN users uu ON uu.u_id = r.r_resolved_id\r\n"
					+ "INNER JOIN rq_status s ON r.rq_status_id = s.rq_status_id\r\n" + "WHERE r.rq_status_id != 1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				rb.add(new Reimbursement(rs.getInt("r_id"), rs.getInt("r_resolved_id"), rs.getInt("r_submission_id"),
						rs.getDouble("amount"), rs.getString("description"), rs.getBytes("img"),
						rs.getString("time_submission"), rs.getInt("rq_type_id"), rs.getInt("rq_status_id"),
						rs.getString("rb_resolved_fname"), rs.getString("rb_resolved_lname"),
						rs.getString("rb_submission_fname"), rs.getString("rb_submission_lname"),
						rs.getString("rq_type"), rs.getString("rq_status")));
			}

		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rb;
	}

	@Override
	public void resolveReimbursement(int userId, int rId, int statusId) {

		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

			String sql = "{call resolve_reimbursement(?,?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, userId);
			cs.setInt(2, rId);
			cs.setInt(3, statusId);
			cs.executeUpdate();

		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Reimbursement> getPendingReimbursements(int id) {
		List<Reimbursement> rb = new ArrayList<>();

		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

			String sql = "SELECT r.r_id, r.r_resolved_id, r.r_submission_id, r.amount, r.description, r.img, r.time_submission, r.rq_type_id,\r\n"
					+ "r.rq_status_id, uu.fname AS rb_resolved_fname, uu.lname AS rb_resolved_lname, u.fname AS rb_submission_fname, u.lname AS\r\n"
					+ "rb_submission_lname, rq.rq_type ,s.rq_status \r\n" + "from reimbursement r\r\n"
					+ "INNER JOIN rq_type rq ON rq.rq_type_id = r.rq_type_id\r\n"
					+ "INNER JOIN users u ON u.u_id = r.r_submission_id\r\n"
					+ "LEFT OUTER JOIN users uu ON uu.u_id = r.r_resolved_id\r\n"
					+ "INNER JOIN rq_status s ON r.rq_status_id = s.rq_status_id\r\n"
					+ "WHERE r.rq_status_id = 1 AND r.r_submission_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				rb.add(new Reimbursement(rs.getInt("r_id"), rs.getInt("r_resolved_id"), rs.getInt("r_submission_id"),
						rs.getDouble("amount"), rs.getString("description"), rs.getBytes("img"),
						rs.getString("time_submission"), rs.getInt("rq_type_id"), rs.getInt("rq_status_id"),
						rs.getString("rb_resolved_fname"), rs.getString("rb_resolved_lname"),
						rs.getString("rb_submission_fname"), rs.getString("rb_submission_lname"),
						rs.getString("rq_type"), rs.getString("rq_status")));
			}

		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rb;
	}

	@Override
	public List<Reimbursement> getEmployeeResolvedReimbursements(int id) {

		List<Reimbursement> rb = new ArrayList<>();

		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

			String sql = "SELECT r.r_id, r.r_resolved_id, r.r_submission_id, r.amount, r.description, r.img, r.time_submission, r.rq_type_id,\r\n"
					+ "r.rq_status_id, uu.fname AS rb_resolved_fname, uu.lname AS rb_resolved_lname, u.fname AS rb_submission_fname, u.lname AS\r\n"
					+ "rb_submission_lname, rq.rq_type ,s.rq_status \r\n" + "from reimbursement r\r\n"
					+ "INNER JOIN rq_type rq ON rq.rq_type_id = r.rq_type_id\r\n"
					+ "INNER JOIN users u ON u.u_id = r.r_submission_id\r\n"
					+ "LEFT OUTER JOIN users uu ON uu.u_id = r.r_resolved_id\r\n"
					+ "INNER JOIN rq_status s ON r.rq_status_id = s.rq_status_id\r\n"
					+ "WHERE r.rq_status_id != 1 AND r.r_submission_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				rb.add(new Reimbursement(rs.getInt("r_id"), rs.getInt("r_resolved_id"), rs.getInt("r_submission_id"),
						rs.getDouble("amount"), rs.getString("description"), rs.getBytes("img"),
						rs.getString("time_submission"), rs.getInt("rq_type_id"), rs.getInt("rq_status_id"),
						rs.getString("rb_resolved_fname"), rs.getString("rb_resolved_lname"),
						rs.getString("rb_submission_fname"), rs.getString("rb_submission_lname"),
						rs.getString("rq_type"), rs.getString("rq_status")));
			}

		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rb;
	}

	@Override
	public List<Type> getStatus() {

		List<Type> status = new ArrayList<>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

			String sql = "SELECT * FROM rq_type";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				status.add(new Type(rs.getInt(1), rs.getString(2)));
			}

		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

}

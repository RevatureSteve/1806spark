package com.kingsgame.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kingsgame.pojo.Reimbursement;
import com.kingsgame.pojo.Type;
import com.kingsgame.pojo.User;
import com.kingsgame.util.Conn;

public class Dao implements DaoInterface{

	public User loginUser(String email, String password) {
		User user = null;
		try (Connection conn = Conn.getConn();){
		String sql = "select users.u_id,users.email,users.password,users.fname,users.lname,users.pos_id,position.pos_type\n" + 
				"from users\n" + 
				"RIGHT JOIN position \n" + 
				"on users.pos_id = position.pos_id where users.email = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			if(password.equals(rs.getString(3))) {
		user = new User(rs.getInt(1),rs.getString(2),
		rs.getString(3),rs.getString(4),rs.getString(5),
		rs.getInt(6), rs.getString(7));
		User.getUser(rs.getInt(1),rs.getString(2),
		rs.getString(3),rs.getString(4),rs.getString(5),
		rs.getInt(6),rs.getString(7));
			}
		}
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
		return user;
	}

	public int createUser(String email, String password, String fname, String lname, int pos_id) {
			int rowsAffected = 0;
			try(Connection conn = Conn.getConn();){
				String sql = "{call new_user(?,?,?,?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, email);
			cs.setString(2, password);
			cs.setString(3, fname);
			cs.setString(4, lname);
			cs.setInt(5, pos_id);
			rowsAffected = cs.executeUpdate();
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			return rowsAffected;
	}
	@Override
	public int createReimbursement(int emp_u_id, double amt, String description, 
			//Object img,
			int rq_type_id) {
		int rowsAffected = 0;
		try(Connection conn = Conn.getConn();){
			String sql = "{call new_reimbursement(?,?,?,?"
		//			+ ",?"
					+ ")}";
		CallableStatement cs = conn.prepareCall(sql);
		cs.setInt(1, emp_u_id);
		cs.setDouble(2, amt);
		cs.setString(3, description);
		//cs.setObject(4, img);
		cs.setInt(4, rq_type_id);
		rowsAffected = cs.executeUpdate();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return rowsAffected;
}

	@Override
	public int updateReimbursement(int rid, int mgrid,  int rqstatusid) {
		int rowsAffected = 0;
		try(Connection conn = Conn.getConn();){
			String sql = "{call update_reimbursement(?,?,?)}";
		CallableStatement cs = conn.prepareCall(sql);
		cs.setInt(1, rid);
		cs.setInt(2, mgrid);
		cs.setInt(3, rqstatusid);
		rowsAffected = cs.executeUpdate();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return rowsAffected;
}


	public List<Reimbursement> getEReimbursements(int r_id, int emp_u_id, int mgr_u_id, double amt, int rq_type_id,
			int rq_status_id) {
		List<Reimbursement>reimList = new ArrayList<>();
		try(Connection conn = Conn.getConn();){
			String sql = "{call sel_emp_reimbursements(?,?,?)}";
		CallableStatement cs = conn.prepareCall(sql);
		cs.setInt(1, emp_u_id);
		cs.setInt(2, rq_type_id);
		cs.setInt(3, rq_status_id);
		ResultSet rs = cs.executeQuery();
		while(rs.next()) {
			Reimbursement reim = new Reimbursement(rs.getInt(1),rs.getInt(2),rs.getInt(3),
					rs.getDouble(4),rs.getString(5),rs.getObject(6),
					rs.getString(7),rs.getInt(8),rs.getInt(9));
			reimList.add(reim);
		}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return reimList;
}

	@Override
	public List<Reimbursement> getMReimbursement(int mgr_u_id,int emp_u_id )
	{List<Reimbursement>reimList = new ArrayList<>();
			try(Connection conn = Conn.getConn();){
				String sql = "{call sel_mgr_reimbursement(?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, mgr_u_id);
			cs.setInt(2, emp_u_id);
			ResultSet rs = cs.executeQuery();
			while(rs.next()) {
				Reimbursement reim = new Reimbursement(rs.getInt(1),rs.getInt(2),rs.getInt(3),
						rs.getDouble(4),rs.getString(5),rs.getObject(6),
						rs.getString(7),rs.getInt(8),rs.getInt(9));
				reimList.add(reim);
			}
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			return reimList;
	}
	
	@Override
	public List<Reimbursement> getAllReimbursement() {
		List<Reimbursement>reimList = new ArrayList<>();
		try(Connection conn = Conn.getConn();){
			String sql = "select * from reimbursement order by rq_status_id";
		CallableStatement cs = conn.prepareCall(sql);

		ResultSet rs = cs.executeQuery();
		while(rs.next()) {
			reimList.add(new Reimbursement(
			rs.getInt(1),rs.getInt(2),rs.getInt(3),
			rs.getDouble(4),rs.getString(5),rs.getObject(6),
			rs.getString(7),rs.getInt(8),rs.getInt(9)));

		}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		System.out.println(reimList);
		return reimList;
	}
	@Override
	public List<User> getAllUsers() {
		List<User>userList = new ArrayList<>();
		try(Connection conn = Conn.getConn();){
			String sql = "SELECT u.u_id, u.email,u.password,u.fname,u.lname,u.pos_id,p.pos_type\n" + 
					"FROM users u\n" + 
					"RIGHT JOIN position p ON u.pos_id = p.pos_id order by pos_type asc";
		CallableStatement cs = conn.prepareCall(sql);

		ResultSet rs = cs.executeQuery();
		while(rs.next()) {
			userList.add(new User(
			rs.getInt(1),rs.getString(2),rs.getString(3),
			rs.getString(4),rs.getString(5),rs.getInt(6),
			rs.getString(7)));

		}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		System.out.println(userList);
		return userList;
	}
	
	@Override
	public List<Reimbursement> getMineReimbursement(int u_id) {
		System.out.println("---------------------------------------------");
		List<Reimbursement>reimList = new ArrayList<>();
		try(Connection conn = Conn.getConn();){
			String sql = "select * from reimbursement where emp_u_id = ?";
		CallableStatement cs = conn.prepareCall(sql);
		cs.setInt(1, u_id);
		ResultSet rs = cs.executeQuery();
		while(rs.next()) {
			reimList.add(new Reimbursement(
			rs.getInt(1),rs.getInt(2),rs.getInt(3),
			rs.getDouble(4),rs.getString(5),rs.getObject(6),
			rs.getString(7),rs.getInt(8),rs.getInt(9)));

		}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		System.out.println("hello---------------------------" + reimList );
		return reimList;
	}
	
	
	
	@Override
	public List<Type> getAllTypes() {
		List<Type>typeList = new ArrayList<>();
		try(Connection conn = Conn.getConn();){
			String sql = "select * from rq_type order by rq_type_id";
		CallableStatement cs = conn.prepareCall(sql);

		ResultSet rs = cs.executeQuery();
		while(rs.next()) {
			typeList.add(new Type(rs.getInt(1),rs.getString(2)));

		}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		System.out.println(typeList);
		return typeList;
	
	
	
	}

}


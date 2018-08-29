package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Position;
import com.revature.domain.Reimbursement;
import com.revature.domain.User;
import com.revature.service.ServiceMethods;
import com.revature.util.DbConnection;

public class UserDaoImpl implements UserDao{

	
	@Override
	public User getUserByEmail(String email) {
		User user=null;
		//What is the method code going to contain? JDBC Code!
		
		try(Connection conn = DbConnection.getConnection()) {
			String sql = "SELECT * FROM users WHERE email= ?";
			PreparedStatement ps = conn.prepareStatement(sql); //pre-compiling the sql statement without the parameter values
			ps.setString(1, email);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()) {
				user = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		User user=null;
		//What is the method code going to contain? JDBC Code!
		
		try(Connection conn = DbConnection.getConnection()) {
			String sql = "SELECT * FROM users WHERE email= ? AND password=?";
			PreparedStatement ps = conn.prepareStatement(sql); //pre-compiling the sql statement without the parameter values
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()) {
				user = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6));
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public String getUserPositionName(int positionId) {
		Position position = null;
		try(Connection conn = DbConnection.getConnection()) {
		String sql = "SELECT * FROM position WHERE pos_id= ?";
		PreparedStatement ps = conn.prepareStatement(sql); //pre-compiling the sql statement without the parameter values
		ps.setInt(1, positionId);
		ResultSet resultSet = ps.executeQuery();
		if(resultSet.next()) {
			position = new Position(resultSet.getInt(1),resultSet.getString(2));
		}

		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return position.getP_name();
}

	@Override
	public int registerEmployee(User employee) {
		int rowsAffected = 0;
		try(Connection conn = DbConnection.getConnection()) {
			String sql = "INSERT INTO USERS(email,password,fname,lname,position_id) VALUES(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql); //pre-compiling the sql statement without the parameter values
			ps.setString(1, employee.getEmail());
			ps.setString(2, ServiceMethods.randomPassword());
			ps.setString(3, employee.getFname());
			ps.setString(4, employee.getLname());
			ps.setInt(5, employee.getPositionId());
			rowsAffected = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAffected;
	}

	@Override
	public List<Reimbursement> getAllRequests() {
		List<Reimbursement> requests = new ArrayList();
		try(Connection conn = DbConnection.getConnection()) {
			String sql = "SELECT r_id,rq_type,fname,lname,R_RESOLVED__UID,rq_status,amount,description,img,time_submission FROM "
					+ "(SELECT REIMBURSEMENT.*,REQUEST_STATUS.*,Request_type.*,users.* FROM reimbursement INNER JOIN "
					+ "request_status ON reimbursement.rq_status_id = request_status.rq_status_id INNER JOIN "
					+ "request_type ON reimbursement.rq_type_id=request_type.rq_type_id INNER JOIN USERS ON "
					+ "reimbursement.R_SUBMISSION_UID = users.u_id)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				requests.add(new Reimbursement(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getBlob(9),rs.getString(10)));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return requests;
	}

	@Override
	public int submitRequest(Reimbursement request) {
		int rowsAffected = 0;
		try(Connection conn = DbConnection.getConnection();) {
		
		String sql = "Insert into Reimbursement(rq_type_id,r_submission_uId,AMOUNT,DESCRIPTION) VALUES(?,?,?,?)";
			
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,request.getRequestTypeId());
		ps.setInt(2, request.getSubmissionUId());
		ps.setInt(3, request.getAmount());
		ps.setString(4, request.getDescription());
		
		rowsAffected = ps.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return rowsAffected;
	}

	@Override
	public List<Reimbursement> getReimbursementsById(int id) {   // Get all the request for a specific employee
		List<Reimbursement> requests = new ArrayList();
		try(Connection conn = DbConnection.getConnection()) {
			String sql = "SELECT r_id,rq_type,fname,lname,R_RESOLVED__UID,rq_status,amount,description,img,time_submission FROM "
					+ "(SELECT REIMBURSEMENT.*,REQUEST_STATUS.*,Request_type.*,users.* FROM reimbursement INNER JOIN "
					+ "request_status ON reimbursement.rq_status_id = request_status.rq_status_id INNER JOIN "
					+ "request_type ON reimbursement.rq_type_id=request_type.rq_type_id INNER JOIN USERS ON "
					+ "reimbursement.R_SUBMISSION_UID = users.u_id) WHERE R_SUBMISSION_UID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				requests.add(new Reimbursement(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getBlob(9),rs.getString(10)));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return requests;
	}

	@Override
	public List<Reimbursement> getReimbursementsByStatus(int status) {
		List<Reimbursement> requests = new ArrayList();
		try(Connection conn = DbConnection.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENT INNER JOIN USERS ON REIMBURSEMENT.R_SUBMISSION_UID = users.u_id WHERE RQ_STATUS_ID =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				requests.add(new Reimbursement(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getBlob(8),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getInt(15)));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return requests;
	}
	@Override
	public List<Reimbursement> getReimbursementsBySubmissionIdAndStatus(int userId, int statusId) {
		List<Reimbursement> requests = new ArrayList();
		try(Connection conn = DbConnection.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENT where rq_status_Id=? AND R_SUBMISSION_UID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, statusId);
			ps.setInt(2, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				requests.add(new Reimbursement(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getBlob(8),rs.getString(9)));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return requests;
	}
	@Override
	public int updateEmployeeName(User employee,String newFname,String newLname) {
		int rowsAffected = 0;
		try(Connection conn = DbConnection.getConnection()) {
			String sql = "UPDATE users SET fname = ?, lname = ? where u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql); //pre-compiling the sql statement without the parameter values
			ps.setString(1, newFname);
			ps.setString(2, newLname);
			ps.setInt(3, employee.getuId());
			rowsAffected = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAffected;
	}
	
	@Override
	public int updateEmployeePassword(User employee,String newPassword) {
		int rowsAffected = 0;
		try(Connection conn = DbConnection.getConnection()) {
			String sql = "UPDATE users SET password = ? where u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql); //pre-compiling the sql statement without the parameter values
			ps.setString(1, newPassword);
			ps.setInt(2, employee.getuId());
			rowsAffected = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAffected;
	}
	
	@Override
	public int updateRequestStatus(int managerId,Reimbursement request,int status) {
		System.out.println("Hits Dao");
		int rowsAffected = 0;
		try(Connection conn = DbConnection.getConnection()) {
			String sql = "UPDATE reimbursement SET RQ_STATUS_ID = ?,R_RESOLVED__UID= ? WHERE R_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql); //pre-compiling the sql statement without the parameter values
			ps.setInt(1, status);
			ps.setInt(2, managerId);
			ps.setInt(3, request.getrId());
			rowsAffected = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAffected;
	}
	@Override
	public List<User> getAllEmployees() {
		List<User> users = new ArrayList();
		
		try(Connection conn = DbConnection.getConnection()) {
			String sql = "SELECT * FROM users";
			PreparedStatement ps = conn.prepareStatement(sql); //pre-compiling the sql statement without the parameter values
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				users.add(new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6)));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	@Override
	public User getEmployeeById(int id) {
		User user = null;
		
		try(Connection conn = DbConnection.getConnection()) {
			String sql = "SELECT * FROM users WHERE U_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql); //pre-compiling the sql statement without the parameter values
			ps.setInt(1,id);
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
			 user = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
	
	
	

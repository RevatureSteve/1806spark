package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.domain.Reimbursement;
import com.revature.util.SetConnectionPropertiesUtil;
import com.revature.domain.Reimbursement;

public class ReimbursementDaoImpl implements ReimbursementDao {
	

	
//READ ONE REIMBURSEMENT BY user ID	

	@Override
	public List<Reimbursement> getReimbursemenstById(int r_id) {
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		try(Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "SELECT * FROM reimbursement WHERE EMP_U_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r_id );
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt("R_ID"), rs.getInt("EMP_U_ID"), rs.getInt("MGR_U_ID"), rs.getInt("RQ_TYPE_ID"),
						rs.getInt("RQ_STATUS_ID"), rs.getInt("AMT"), rs.getString("DESCRIPTION"), rs.getString("TIMESUBMISSION"),rs.getString("IMG")));
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
		return reimbursements;
		
	}
	
		



//GET ALL REIMBURSEMENTS
	@Override
	public List<Reimbursement> getAllReimbursements() {
		
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		try(Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "SELECT * FROM reimbursement";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt("R_ID"), rs.getInt("EMP_U_ID"), rs.getInt("MGR_U_ID"), rs.getInt("RQ_TYPE_ID"),
						rs.getInt("RQ_STATUS_ID"), rs.getInt("AMT"), rs.getString("DESCRIPTION"), rs.getString("TIMESUBMISSION"),rs.getString("IMG")));
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
		
		return reimbursements;
	}

//UPDATE REIMBURSEMENT STATUS
	public int changeStatus(int rq_status_id, int r_id) {
		System.out.println( rq_status_id);
		int rowsAffected = 0;
		try(Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			String sql = "UPDATE REIMBURSEMENT SET rq_status_id = ? WHERE r_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rq_status_id);
			ps.setInt(2, r_id);
			
			 rowsAffected = ps.executeUpdate();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAffected;
	}



//CREATE NEW REIMBURSEMENT
	
	@Override
	public boolean addReimbursement(int emp_u_id, int mgr_u_id,
			double amt, String description, int rq_type_id, int rq_status_id  ) {
		
		
			
		try(Connection conn = SetConnectionPropertiesUtil.getConnection();){
			CallableStatement cs = conn.prepareCall("{CALL ADD_REIMBURSEMENT (?, ?, ?, ?, ?, ?)}");
			
			cs.setInt(1, emp_u_id);
			cs.setInt(2, mgr_u_id);
			cs.setDouble(3, amt);
			cs.setString(4, description);
			cs.setInt(5, rq_type_id);
			cs.setInt(6, rq_status_id);
			
			cs.execute();
			cs.close();
			
			System.out.println("Stored insert procedure called");
			
			
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

		return true;
	}





}




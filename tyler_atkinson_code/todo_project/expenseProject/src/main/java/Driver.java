import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.domain.Reimbursement;
import com.revature.domain.Users;
import com.revature.service.AppService;
import com.revature.util.SetConnectionPropertiesUtil;

public class Driver {
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("testy mctest test");

		//if wrong credentials, will return null otherwise returns user string[]

		String emailInput = "boss@man";

		String pwInput = "abc";


		Users validUser = new AppService().login(new Users (0,"", "", emailInput, pwInput, 0));
	
		System.out.println("confirm valid user " + validUser);
	
//		addAReimb();}
//	
//	public static void addAReimb() {
//		
//		ReimbursementDaoImpl nowAddReimbursement = new ReimbursementDaoImpl();
//		
//	
//		Scanner scan = new Scanner(System.in);
//	
//
//		System.out.println("emp id #");
//	
//		int emp_u_id = scan.nextInt();
//	
//		System.out.println("your mgrs id: ");
//		int mgr_u_id = scan.nextInt();
//		
//		System.out.println("amt");
//		double amt = scan.nextDouble();
//		
//		System.out.println("description");
//		String description = scan.next();
//		
//		System.out.println("rq_type_id");
//		int rq_type_id = scan.nextInt();
//		
//		System.out.println("rq_status_id");
//		int rq_status_id = scan.nextInt();
//		
//		
//		nowAddReimbursement.addReimbursement(emp_u_id, mgr_u_id, amt, description, rq_type_id, rq_status_id);
//		
//	}
	
	
	
			
			
				
			try(Connection conn = SetConnectionPropertiesUtil.getConnection();){
				CallableStatement cs = conn.prepareCall("{CALL ADD_REIMBURSEMENT (?, ?, ?, ?, ?, ?)}");
				
				cs.setInt(1, 2);
				cs.setInt(2, 2);
				cs.setDouble(3, 2);
				cs.setString(4, "Still Testing");
				cs.setInt(5, 1);
				cs.setInt(6, 1);
				
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

			
			
		
		

		
		try(Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "SELECT * FROM reimbursement WHERE r_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 1 );
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Reimbursement.add(new Reimbursement(rs.getInt("R_ID"), rs.getInt("EMP_U_ID"), rs.getInt("MGR_U_ID"), rs.getInt("RQ_TYPE_ID"),
						rs.getInt("RQ_STATUS_ID"), rs.getInt("AMT"), rs.getString("DESCRIPTION"), rs.getString("TIMESUBMISSION"),rs.getString("IMG")));
			}
		}
}
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
		
}

		


		
	
	
	


	



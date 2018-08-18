import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.domain.Reimbursement;
import com.revature.domain.Users;
import com.revature.service.AppService;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("testy mctest test");
//if wrong credentials, will return null otherwise returns user string[]
String emailInput = "boss@man";
String pwInput = "abc";

Users validUser = new AppService().login(new Users (0,"", "", emailInput, pwInput, 0));
	
	System.out.println("confirm valid user " + validUser);
	
//int rIdInput = 1021;
//
//Reimbursement reReq = new AppService().getReReq(new Reimbursement (rIdInput, 0, 0, 0, 0, 0, "", "", ""));
//	
//System.out.println("this is a reimbursement request: " + reReq);
	

	}

}

package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pogo.Reimbursement;
import com.revature.pogo.Users;
import com.revature.service.AppService;

/**
 * Servlet implementation class ManagerOptionsServlet
 * 
 * @author Alex Moraga
 * 
 */
public class ManagerOptionsServlet extends HttpServlet {
    /*
     * url - /managerOptions
     */
	
	private AppService aS = new AppService();
	
    public ManagerOptionsServlet() {
        super();
    }
	
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	System.out.println("ManagerOptionsServlet -POST"); 
		ObjectMapper mapper = new ObjectMapper();
		// Reads the json that's being sent through the POST request
		ServletInputStream json = request.getInputStream();
		Reimbursement reimb = mapper.readValue(json, Reimbursement.class);

		System.out.println(reimb);
		
		int r_Id = reimb.getR_Id();
		int mgr_U_Id = reimb.getMgr_U_Id();
		int rq_Status_Id = reimb.getRq_Status_Id();
		System.out.println(r_Id + ""+ mgr_U_Id + "" + rq_Status_Id);
		int success = aS.
    }

}

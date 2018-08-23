package com.revature.servlets;

import java.io.DataOutput;
import java.io.IOException;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.Reimbursements;
import com.revature.domain.User;

/**
 * Servlet implementation class NewReimbursementServlet
 */
public class NewReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl dao = new UserDaoImpl();

	
    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	ObjectMapper mapper = new ObjectMapper();
		ServletInputStream data = req.getInputStream();
		ObjectNode n = mapper.readValue(data,ObjectNode.class);
    	
		int emp_uid = 0;
		int amount  = 0;
		String description  = null;
		Blob img  = null;
		int rqtypeid = 0;
		int rqstatusid  = 0;
		
		
		emp_uid = Integer.parseInt(n.get("emp_uid").textValue());
		amount = Integer.parseInt(n.get("amount").textValue());
		description = n.get("description").textValue();
		rqtypeid = Integer.parseInt(n.get("rqtypeid").textValue());
		rqstatusid = Integer.parseInt(n.get("rqstatusid").textValue());
		
		dao.createNewReimbursement(emp_uid,amount, description, img, rqtypeid, rqstatusid);
		
		System.out.println("T-Rex");
		
		
		}
}
	


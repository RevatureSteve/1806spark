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
    	System.out.println(n);
		int emp_u_id = 0;
		int amount  = 0;
		String description  = null;
		int rqtypeid = 0;
		
		
		emp_u_id = n.get("emp_u_id").asInt();
		amount = n.get("amt").asInt();
		description = n.get("description").asText();
		rqtypeid = n.get("rq_type_id").asInt();
		
		dao.createNewReimbursement(emp_u_id,amount, description, rqtypeid);
		
		System.out.println("T-Rex");
		
		
		}
}
	


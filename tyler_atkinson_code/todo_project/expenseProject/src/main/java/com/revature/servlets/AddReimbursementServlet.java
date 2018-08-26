package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.dao.ReimbursementDaoImpl;

/**
 * Servlet implementation class AddReimbursementServlet
 */
public class AddReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReimbursementServlet() {
        super();
     
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	System.out.println("Post  on Addreimbursement servlet initiated");
    	
    	ReimbursementDaoImpl nowAddReimbursement = new ReimbursementDaoImpl();
    	
    	ObjectMapper mapper = new ObjectMapper();
    	ServletInputStream data = request.getInputStream();
    	ObjectNode node = mapper.readValue(data, ObjectNode.class);
    	
    	System.out.println("object node stuff");
    	
    	int a = node.get("uid").intValue();
    	 System.out.println(a);
    	 int b = node.get("mgruid").intValue();
    	 System.out.println(b);
    	 double c = node.get("amt").intValue();
    	 System.out.println(c);
    	 String d = node.get("description").asText();
    	 System.out.println(d);
    	 int e = node.get("rqtypeid").intValue();
    	 System.out.println(e);
    	 int f = node.get("rqstatusid").intValue();
    	 System.out.println(f);
    	 
    	 
    	 
    	
    	
    	
    	nowAddReimbursement.addReimbursement(a,b,c,d,e,f);
    	
		response.getWriter();
	}


}

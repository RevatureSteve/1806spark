package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.domain.Reimbursement;
import com.revature.service.ReimbursementBL;


public class ChangeReimStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ChangeReimStatusServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReimbursementBL bl = new ReimbursementBL();
		
		int rId;
		int mgrUId;
		int rqStatusId;
		
		
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream data = request.getInputStream();
		ObjectNode node = mapper.readValue(data,  ObjectNode.class);
		
		rId = node.get("rId").intValue();
		mgrUId = node.get("mgrUId").intValue();
		rqStatusId = node.get("rqStatusId").intValue();

		bl.changeReimStatus(rId, mgrUId, rqStatusId);
		
		
		
		System.out.println("end servlet");
		

	}
}

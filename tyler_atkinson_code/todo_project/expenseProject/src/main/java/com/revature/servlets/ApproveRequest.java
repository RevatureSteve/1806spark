package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.domain.Reimbursement;
import com.revature.service.AppService;

/**
 * Servlet implementation class ApproveRequest
 */
public class ApproveRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Post  on Addreimbursement servlet initiated");
    	
		AppService appService = new AppService();
    	ObjectMapper mapper = new ObjectMapper();
    	BufferedReader reader = request.getReader();
    	
//    	ServletInputStream data = request.getInputStream();
    	Reimbursement update = mapper.readValue(reader, Reimbursement.class);
    	
//    	System.out.println("object node stuff");
    	
//    	int b = node.get("r_id").intValue();
//   	 System.out.println(b);
//    	
//    	int a = node.get("rq_status_id").intValue();
//    	 System.out.println(a);
    	 
    	System.out.println(update.getR_id());
    	
    	appService.changeStatus(update.getRq_status_id(), update.getR_id());
     	
 		response.getWriter();
	}

}

package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.BankUserDTO;
import com.revature.model.BankAccount;
import com.revature.model.BankUser;
import com.revature.service.AppService;

/**
 * Servlet implementation class AjaxBankInfoServlet
 */
@WebServlet("/ajaxBankInfo" )
public class AjaxBankInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxBankInfoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("AjaxBankInfoServlet -GET");
		AppService service = new AppService();
		HttpSession session = request.getSession();
		
		BankUser sessionUser = (BankUser) session.getAttribute("user");
		
		if(sessionUser != null){
			BankAccount bankAccount = service.getBankAccountByUsername(sessionUser);
		
			if(bankAccount !=null){
				System.out.println("---------------Converting BankUser & Account to DTO");
				BankUserDTO userDTO = service.convertToBankUserDTO(sessionUser, bankAccount);
				
				System.out.println("---------------JSON Mapping DTO------------------");
				ObjectMapper mapper = new ObjectMapper();
				
				String json = mapper.writeValueAsString(userDTO);
				
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				out.write(json);
			}else{
				response.setStatus(418);
			}
		}else{
			response.setStatus(418);
		}
	}



}

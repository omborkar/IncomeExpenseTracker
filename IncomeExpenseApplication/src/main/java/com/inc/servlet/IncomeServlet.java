package com.inc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inc.dao.IncomeDao;
import com.inc.pojo.Income;
import com.inc.pojo.User;

@WebServlet("/IncomeServlet")
public class IncomeServlet extends HttpServlet {

	Income inc = new Income(); //pojo class income object
	IncomeDao incd = new IncomeDao();  //dao class incomedao object



	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		User user=(User)session.getAttribute("user");
		String action=req.getParameter("action");
		if(action!=null && action.equals("delete")) {
			int id = Integer.parseInt(req.getParameter("id"));
			boolean b = incd.deleteIncome(id);
			if(b) {
				resp.sendRedirect("IncomeServlet");
			}

		}
		else if(action!=null && action.equals("edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			Income i= incd.getIncome(id);
			session.setAttribute("inc", i);
			resp.sendRedirect("update_income.jsp");

		}
		
		else if(action!=null && action.equals("searchByIncType")){
			String type = req.getParameter("type");
			List<Income> inclist=incd.getIncomeListByType(user.getId(), type);
			session.setAttribute("inclist", inclist);
			resp.sendRedirect("incomelist.jsp");
		}
		
		else {
			List<Income> inclist = incd.getIncomeList(user.getId());
			session.setAttribute("inclist", inclist);
			resp.sendRedirect("incomelist.jsp");
		}

	}
	
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String action=req.getParameter("action");
		

		User user=(User)session.getAttribute("user");
		String incomeType=req.getParameter("incomeType");
		String description=req.getParameter("description");
		
		inc.setIncomeType(incomeType);   //set the parameters value and pass it on to Income dao
		
		inc.setDescription(description);
		

		if(action!=null && action.equals("addIncome")) {
			
			double income=Double.parseDouble(req.getParameter("income"));
			inc.setIncome(income);
			int userid=Integer.parseInt(req.getParameter("userId"));
			inc.setUserId(userid);
			
			boolean b = incd.addIncome(inc); // income dao class obj and method
			if(b) {
				resp.sendRedirect("index.jsp");  // sending resp to home page
			}
			else {
				resp.sendRedirect("addincome.jsp"); // sending resp to same page again 
			}
		}
		
		
		else if(action!=null && action.equals("updateIncome")){
			
			double income=Double.parseDouble(req.getParameter("income"));
			inc.setIncome(income);
			int userid=Integer.parseInt(req.getParameter("userId"));
			inc.setUserId(userid);
			
			int id = Integer.parseInt(req.getParameter("id"));
			inc.setId(id);
			boolean b= incd.updateIncome(inc);
			if(b) {
				resp.sendRedirect("IncomeServlet");
			}
		}
			
			else if(action!=null && action.equals("srch")) {
				String search = req.getParameter("search");
				resp.sendRedirect("incomelist.jsp");
				List<Income> inclist=incd.getIncomeListByDescription(user.getId(), search);
				session.setAttribute("inclist", inclist);
				
			}

		
	}

}

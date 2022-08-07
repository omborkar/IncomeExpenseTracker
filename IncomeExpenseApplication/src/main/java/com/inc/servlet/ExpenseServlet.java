package com.inc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inc.dao.ExpenseDao;
import com.inc.dao.IncomeDao;
import com.inc.pojo.Expense;

import com.inc.pojo.User;

@WebServlet("/ExpenseServlet")
public class ExpenseServlet extends HttpServlet {

	IncomeDao incd = new IncomeDao();
	Expense exp = new Expense();
	ExpenseDao expd = new ExpenseDao();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		User user=(User)session.getAttribute("user");




		String action=req.getParameter("action");
		if(action!=null && action.equals("delete")) {
			int id = Integer.parseInt(req.getParameter("id"));
			boolean b = expd.deleteExpense(id);
			if(b) {
				resp.sendRedirect("ExpenseServlet");
			}

		}
		else if(action!=null && action.equals("edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			Expense e= expd.getExpense(id);
			session.setAttribute("exp", e);
			resp.sendRedirect("update_expense.jsp");


		}

		else if(action!=null && action.equals("searchByExpType")){
			String type = req.getParameter("type");
			List<Expense> explist=expd.getExpenseListByType(user.getId(), type);
			session.setAttribute("explist", explist);
			resp.sendRedirect("expenselist.jsp");
		}

		else {
			List<Expense> explist = expd.getExpenseList(user.getId());
			session.setAttribute("explist", explist);
			resp.sendRedirect("expenselist.jsp");
		}



	}

/*
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String action=req.getParameter("action");
		HttpSession session = req.getSession();

				double expense=Double.parseDouble(req.getParameter("expense")); //get parameters from jsp page 
		User user=(User)session.getAttribute("user");
		String expenseType=req.getParameter("expenseType");
		String description=req.getParameter("description");
				int userid=Integer.parseInt(req.getParameter("userId"));
		exp.setExpenseType(expenseType);   //set the parameters value and pass it on to Income dao
				exp.setUserId(userid);
		exp.setDescription(description);
				exp.setExpense(expense);
				
	





	if(action!=null && action.equals("addExpense")) {
			
			double expense=Double.parseDouble(req.getParameter("expense"));
			exp.setExpense(expense);
			int userid=Integer.parseInt(req.getParameter("userId"));
			exp.setUserId(userid);
			
			boolean b = expd.addExpense(exp);  // income dao class obj and method
			if(b) {
				resp.sendRedirect("index.jsp");  // sending resp to home page
			}
			else {
				resp.sendRedirect("addexpense.jsp"); // sending resp to same page again 
			}
		}
//
//
//		else if(action!=null && action.equals("updateExpense")){
//
//			double expense=Double.parseDouble(req.getParameter("expense"));
//			exp.setExpense(expense);
//			int userid=Integer.parseInt(req.getParameter("userId"));
//			exp.setUserId(userid);
//
//			int id = Integer.parseInt(req.getParameter("id"));
//			exp.setId(id);
//			boolean b= expd.updateExpense(exp);
//			if(b) {
//				resp.sendRedirect("ExpenseServlet");
//			}
//		}
//
//		else if(action!=null && action.equals("srch")) {
//			String search = req.getParameter("search");
//			resp.sendRedirect("expenselist.jsp");
//			List<Expense> explist=expd.getExpenseListByDescription(user.getId(), search);
//			session.setAttribute("explist", explist);
//
//		}
	}

}



//		int userid=Integer.parseInt(req.getParameter("userId"));
//		double expense=Double.parseDouble(req.getParameter("expense"));
//		double bal=incd.getBalance(userid);
//		if(bal>expense) {
//
//
//			boolean c = expd.addexpense(exp); // income dao class obj and method
//			if(c) {
//				resp.sendRedirect("index.jsp");  // sending resp to home page
//			}
//			else {
//				resp.sendRedirect("addexpense.jsp"); // sending resp to same page again 
//			}
//		}else {
//			req.setAttribute("expmsg", "Your Expense amount is greater then balance please Re-Enter Expense Amount");
//			RequestDispatcher rd=req.getRequestDispatcher("addexpense.jsp");
//			rd.include(req, resp);
//		}


*/
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String action=req.getParameter("action");
		

		User user=(User)session.getAttribute("user");
		String expenseType=req.getParameter("expenseType");
		String description=req.getParameter("description");
		
		exp.setExpenseType(expenseType);   //set the parameters value and pass it on to Income dao
		
		exp.setDescription(description);
		

		if(action!=null && action.equals("addExpense")) {
			
			double expense=Double.parseDouble(req.getParameter("expense"));
			exp.setExpense(expense);
			int userid=Integer.parseInt(req.getParameter("userId"));
			exp.setUserId(userid);
			
			boolean b = expd.addExpense(exp); // income dao class obj and method
			if(b) {
				resp.sendRedirect("index.jsp");  // sending resp to home page
			}
			else {
				resp.sendRedirect("addexpense.jsp"); // sending resp to same page again 
			}
		}
		
		
		else if(action!=null && action.equals("updateExpense")){
			
			double expense=Double.parseDouble(req.getParameter("expense"));
			exp.setExpense(expense);
			int userid=Integer.parseInt(req.getParameter("userId"));
			exp.setUserId(userid);
			
			int id = Integer.parseInt(req.getParameter("id"));
			exp.setId(id);
			boolean b= expd.updateExpense(exp);
			if(b) {
				resp.sendRedirect("ExpenseServlet");
			}
		}
			
			else if(action!=null && action.equals("srch")) {
				String search = req.getParameter("search");
				resp.sendRedirect("expenselist.jsp");
				List<Expense> explist=expd.getExpenseListByDescription(user.getId(), search);
				session.setAttribute("explist", explist);
				
			}

		
	}

}










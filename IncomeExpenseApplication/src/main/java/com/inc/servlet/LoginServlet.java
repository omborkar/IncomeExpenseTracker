package com.inc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inc.dao.IncomeDao;
import com.inc.dao.UserDao;
import com.inc.pojo.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	IncomeDao incd=new IncomeDao();
	User u = new User();
	UserDao ud = new UserDao();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect("index.jsp");
	
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String email=req.getParameter("email");
		String passw=req.getParameter("passw");
		u=ud.userLogin(email,passw);
		if(u!=null && email!= null && u.getEmail().equals(email) && u.getPassword().equals(passw)) {
			session.setAttribute("user", u);
			session.setAttribute("bal", incd.getBalance(u.getId()));
			resp.sendRedirect("index.jsp");
		}
		else {
			req.setAttribute("lmsg", "OOPS! Username and Password password did'nt match!");
			RequestDispatcher rd=req.getRequestDispatcher("adduser.jsp");
			rd.include(req, resp);

		}

	}

}

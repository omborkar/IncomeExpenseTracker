package com.inc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inc.dao.UserDao;
import com.inc.pojo.User;

@WebServlet("/UserServlet")
public class UserServlet  extends HttpServlet{
	UserDao ud=new UserDao();

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		HttpSession session=req.getSession();
		User user =(User)session.getAttribute("user");
	}

	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        User u = new User();
		String email=req.getParameter("email");
		String password1=req.getParameter("passw1");
		String password2=req.getParameter("passw2");
		String action=req.getParameter("action");
		if(action!=null && action.equals("adduser")) {

			if(email!=null && password1.equals(password2)) {

				boolean b=ud.adduser(email, password1);
				if(b) {
					resp.sendRedirect("index.jsp");
				}else {
					req.setAttribute("lmsg", "User Already Exists");
					RequestDispatcher rd=req.getRequestDispatcher("adduser.jsp");
					rd.include(req, resp);
				}

			}
			else {
				req.setAttribute("lmsg", "OOPS! Password and confirm password did'nt match!");
				RequestDispatcher rd=req.getRequestDispatcher("adduser.jsp");
				rd.include(req, resp);

			}
		}
		else if(action!=null && action.equals("updateuser")){
			HttpSession session = req.getSession();
			String name=req.getParameter("name");
			String contact=req.getParameter("contact");
			int id = Integer.parseInt(req.getParameter("id"));
			u.setContact(contact);
			u.setEmail(email);
			u.setName(name);
            u.setId(id);
            u.setPassword(password1);
            boolean b =ud.updateUser(u);
            if(b) {
            	session.setAttribute("user", u);
            	resp.sendRedirect("index.jsp");
            }
		}
	}


}

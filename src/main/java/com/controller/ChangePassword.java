package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/change_password")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		String newPassword = request.getParameter("newPassword");
		String oldPassword = request.getParameter("oldPassword");
		HttpSession session = request.getSession();
		UserDao dao = new UserDao();
		if(dao.checkOldPassword(uid, oldPassword)) {
			if(dao.changePassword(uid, newPassword)) {
				session.setAttribute("succMsg", "Password Changed Successfully");
				response.sendRedirect("changePassword.jsp");
			}else {
				session.setAttribute("errorMsg", "something wrong on server");
				response.sendRedirect("changePassword.jsp");
			}
		}else {
			session.setAttribute("errorMsg", "Invalid Old Password");
			response.sendRedirect("changePassword.jsp");
		}
	}

}

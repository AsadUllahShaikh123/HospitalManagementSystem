package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.User;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin_login")
public class AdminServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		if(email.equals("admin@gmail.com") && password.equals("admin")) {
			session.setAttribute("adminObj", new User());
			response.sendRedirect("admin/index.jsp");
		}else {
			session.setAttribute("errorMsg","Invalid Email or Password");
			response.sendRedirect("admin_login.jsp");
		}
		
	}

}

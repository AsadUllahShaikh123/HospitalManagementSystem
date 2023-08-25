package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.entities.User;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/userLogin")
public class UserLogin extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();
		UserDao dao = new UserDao();
		User user = null;
		try {
			user = dao.userLogin(email, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(user !=null) {
			session.setAttribute("userObj", user);
			response.sendRedirect("index.jsp");
		}else {
			session.setAttribute("errorMsg", "invalid email and password");
			response.sendRedirect("user_login.jsp");
		}
		

	}

}

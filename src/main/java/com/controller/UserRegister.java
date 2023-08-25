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
 * Servlet implementation class UserRegister
 */
@WebServlet("/user_register")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		UserDao userDao = new UserDao();
		HttpSession session = request.getSession();
		try {
			
			boolean registered = userDao.userRegister(user);
			if(registered) {
				session.setAttribute("succMsg", "Registered Successfully");
				response.sendRedirect("signup.jsp");
			}else {
				session.setAttribute("errMsg","Something wrong on server");
				response.sendRedirect("signup.jsp");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

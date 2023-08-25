package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.entities.Doctor;

/**
 * Servlet implementation class DoctorLogin
 */
@WebServlet("/doctor_login")
public class DoctorLogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		DoctorDao dao = new DoctorDao();
		Doctor doctor = null;
		try {
			doctor = dao.login(email, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(doctor !=null) {
			session.setAttribute("doctorObj", doctor);
			response.sendRedirect("doctor/index.jsp");
		}else {
			session.setAttribute("errorMsg", "Invalid Email and Password");
			response.sendRedirect("doctor_login.jsp");
		}
	}

}

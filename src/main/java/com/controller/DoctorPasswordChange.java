package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;

/**
 * Servlet implementation class DoctorPasswordChange
 */
@WebServlet("/change_doctor_password")
public class DoctorPasswordChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int doctorId = Integer.parseInt(request.getParameter("d_id"));
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		
		DoctorDao dao = new DoctorDao();
		HttpSession session = request.getSession();
		
		if(dao.checkOldPassword(doctorId, oldPassword)) {
			if(dao.changePassword(doctorId, newPassword)) {
				session.setAttribute("succMsg", "Password Changed Successfully");
				response.sendRedirect("doctor/edit_profile.jsp");
			}else {
				session.setAttribute("errorMsg", "something went wrong on server");
				response.sendRedirect("doctor/edit_profile.jsp");
			}
		}else {
			session.setAttribute("errorMsg", "invalid old password");
			response.sendRedirect("doctor/edit_profile.jsp");
		}
	}

	
	
	
	
	
	
	
}

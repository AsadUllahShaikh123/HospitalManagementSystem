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

/**
 * Servlet implementation class DeleteDoctor
 */
@WebServlet("/delete_doctor")
public class DeleteDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		DoctorDao dao = new DoctorDao();
		boolean deleted = false;
		HttpSession session = request.getSession();
		
		try {
			deleted = dao.deleteDoctor(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(deleted) {
			session.setAttribute("succMsg", "Doctor Deleted Successfully");
			response.sendRedirect("admin/view_doctor.jsp");
		}
		else {
			session.setAttribute("errorMsg", "Something wrong on server");
			response.sendRedirect("admin/view_doctor.jsp");
		}
		
	}

	
}

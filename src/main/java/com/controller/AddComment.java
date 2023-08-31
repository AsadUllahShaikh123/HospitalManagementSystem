package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDao;

/**
 * Servlet implementation class AddComment
 */
@WebServlet("/add_comment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id")) ;
		int doctorId = Integer.parseInt(request.getParameter("did"));
		String comment = request.getParameter("comment");
		boolean update = false;
		AppointmentDao dao = new AppointmentDao();
		
		HttpSession session = request.getSession();
		try {
		  update = dao.updateCommentStatus(id, doctorId, comment);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(update ) {
			session.setAttribute("succMsg", "comment Updated");
			response.sendRedirect("doctor/patient.jsp");
		}
		else {
			session.setAttribute("errorMsg", "Something wrong on Server");
			response.sendRedirect("doctor/patient.jsp");
		}
	}

}

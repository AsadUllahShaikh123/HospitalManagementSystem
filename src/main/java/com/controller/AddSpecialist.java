package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SpecialistDao;
import com.entities.User;

/**
 * Servlet implementation class AddSpecialist
 */
@WebServlet("/addSpecialist")
public class AddSpecialist extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String specialistName = request.getParameter("specialistName");
		boolean added = false;
		SpecialistDao dao = new SpecialistDao();
		try {
			added = dao.addSpecialist(specialistName);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		if(added) {
			session.setAttribute("succMsg", "Specialist Added");
			response.sendRedirect("admin/index.jsp");
		}else {
			session.setAttribute("errorMsg","something wrong on server");
			response.sendRedirect("admin/index.jsp");
		}
		
		
	}

}

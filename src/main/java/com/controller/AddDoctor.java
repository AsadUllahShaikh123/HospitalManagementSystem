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

@WebServlet("/add_doctor")
public class AddDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullName = request.getParameter("fullName");
		String dob = request.getParameter("dob");
		String qualification = request.getParameter("qualification");
		String specialist = request.getParameter("specialist");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		
		Doctor doctor = new Doctor();
		doctor.setFullName(fullName);
		doctor.setDate(dob);
		doctor.setSpecialist(specialist);
		doctor.setQualification(qualification);
		doctor.setEmail(email);
		doctor.setMobile(mobile);
		doctor.setPassword(password);
		
		DoctorDao dao = new DoctorDao();
		HttpSession session = request.getSession();
		boolean registered = false;
		try {
			registered = dao.registerDoctor(doctor);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(registered) {
			session.setAttribute("succMsg", "Doctor Added Successfully");
			response.sendRedirect("admin/doctor.jsp");
		}else {
			session.setAttribute("errorMsg", "Something wrong on server");
			response.sendRedirect("admin/doctor.jsp");
		}
	}

}

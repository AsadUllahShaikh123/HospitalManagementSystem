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


@WebServlet("/edit_doctor")
public class EditDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullName = request.getParameter("fullName");
		String dob = request.getParameter("dob");
		String qualification =request.getParameter("qualification");
		String specialist = request.getParameter("specialist");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		int id = Integer.parseInt(request.getParameter("id"));
		Doctor doctor = new Doctor();
		doctor.setFullName(fullName);
		doctor.setEmail(email);
		doctor.setDate(dob);
		doctor.setQualification(qualification);
		doctor.setMobile(mobile);
		doctor.setSpecialist(specialist);
		doctor.setPassword(password);
		doctor.setId(id);
		DoctorDao dao = new DoctorDao();
		boolean updated = false;
		HttpSession session = request.getSession();
		try {
			updated = dao.updateDoctor(doctor);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(updated) {
			session.setAttribute("succMsg", "Doctor Updated Successfully");
			response.sendRedirect("admin/view_doctor.jsp");
		}else {
			session.setAttribute("errorMsg", "Something wrong on server");
			response.sendRedirect("admin/view_doctor.jsp");
		}
	}

}

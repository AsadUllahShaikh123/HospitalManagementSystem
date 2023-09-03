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
 * Servlet implementation class EditDoctorProfile
 */
@WebServlet("/edit_doctor_profile")
public class EditDoctorProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullName = request.getParameter("fullName");
		String dob = request.getParameter("dob");
		String qualification = request.getParameter("qualification");
		String specialist = request.getParameter("specialist");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		int id = Integer.parseInt(request.getParameter("id"));

		Doctor d = new Doctor();
		d.setId(id);
		d.setFullName(fullName);
		d.setDate(dob);
		d.setQualification(qualification);
		d.setSpecialist(specialist);
		d.setEmail(email);
		d.setMobile(mobile);
		HttpSession session = request.getSession();
		
		DoctorDao dao = new DoctorDao();
		boolean edited = false;
		try {
		    edited = dao.editDoctorProfile(d);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		if(edited) {
			Doctor updateDoctor = null;
			try {
				updateDoctor = dao.getDoctorById(id);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// we are updating the doctor in our website also
			session.setAttribute("doctorObj", updateDoctor);
			session.setAttribute("succMsgd", "Doctor Update Successfully");
			response.sendRedirect("doctor/edit_profile.jsp");
		}else {
			session.setAttribute("succMsgd", "Something went wrong on server");
			response.sendRedirect("doctor/edit_profile.jsp");
		}
		
	}

}

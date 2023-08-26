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
import com.entities.Appointment;

/**
 * Servlet implementation class AddAppointment
 */
@WebServlet("/add_appointment")
public class AddAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String fullName = request.getParameter("fullName");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String appointDate = request.getParameter("appoint_date");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String disease = request.getParameter("diseases");
		int doctorId = Integer.parseInt(request.getParameter("doctor"));
		String address = request.getParameter("address");
		
		Appointment appointment = new Appointment();
		appointment.setUserId(userId);
		appointment.setFullName(fullName);
		appointment.setGender(gender);
		appointment.setAge(age);
		appointment.setAppointDate(appointDate);
		appointment.setEmail(email);
		appointment.setPhoneNo(phone);
		appointment.setDiseases(disease);
		appointment.setDoctorId(doctorId);
		appointment.setAddress(address);
		appointment.setStatus("pending");
		
		AppointmentDao dao = new AppointmentDao();
        HttpSession session = request.getSession();
        boolean added = false;
		try {
			added = dao.addAppointment(appointment);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(added) {
			session.setAttribute("succMsg", "Appointment Success");
			response.sendRedirect("user_appointment.jsp");
		}else {
			session.setAttribute("errorMsg", "Something wrong on server");
			response.sendRedirect("user_appointment.jsp");
		}
		
	}

}

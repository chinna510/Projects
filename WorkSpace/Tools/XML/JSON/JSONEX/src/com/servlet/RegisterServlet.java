package com.servlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.User;
import com.pojo.User1;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String[] address = request.getParameterValues("address");
		long phone = Long.parseLong(request.getParameter("phone"));

		User user = new User();
		user.setFname(fname);
		user.setLname(lname);
		user.setAddress(address);
		user.setPhone(phone);
		ObjectMapper mapper = new ObjectMapper();

		String jsonInString = mapper.writeValueAsString(user);
		System.out.println(jsonInString);
		RegisterServlet rs = new RegisterServlet();
		rs.convertToJson(jsonInString);

	}

	private void convertToJson(String jsonInString) throws JsonParseException, JsonMappingException, IOException {
		User1 user1 = new ObjectMapper().readValue(jsonInString, User1.class);
		System.out.println("Java Object created from JSON String ");
		System.out.println("JSON String : " + jsonInString);
		System.out.println("Java Object : " + user1);
	}
}
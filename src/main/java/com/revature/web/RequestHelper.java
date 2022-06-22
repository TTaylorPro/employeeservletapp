package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDao;
import com.revature.models.Employee;
import com.revature.service.EmployeeService;

public class RequestHelper {
	// Employee Service

	private static EmployeeService eServ = new EmployeeService(new EmployeeDao());

	// Object Mapper for front end
	private static ObjectMapper om = new ObjectMapper();
	
	public static void processEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//1. set the content type to be application/json
		//response.setContentType("application/json");
		response.setContentType("text/html");
		
		//2. Call the findAll() method from the employee service
		List<Employee> emps = eServ.getAll();
		//3. transform the list into a string
		String jsonString = om.writeValueAsString(emps);
		//write it out
		PrintWriter out = response.getWriter();
		out.write(jsonString);
		
	}

	public static void processRegistration(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String username = request.getParameter("username");

		String password = request.getParameter("password");

		String firstName = request.getParameter("firstname");

		String lastName = request.getParameter("lastname");
		
		Employee e = new Employee(username, password, firstName, lastName);
		
		int pk = eServ.register(e);
		
		if (pk > 0) {
			e.setId(pk);
			
			HttpSession session = request.getSession();
			session.setAttribute("the-user", e);
			
			request.getRequestDispatcher("welcome.html").forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			
			response.setContentType("text/html");
			
			out.println("<h1> Registration failed: User already exists </h1>");
			out.println("<a href=\"index.html\"");
		}

	}

	public static void processLogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 1. Extract the parameters from the request (username and password)
		String username = request.getParameter("username");

		String password = request.getParameter("password");

		Employee e = eServ.confirmLogin(username, password);

		if (e.getId() > 0) {
			HttpSession session = request.getSession();

			session.setAttribute("the-user", e);

			PrintWriter out = response.getWriter();
			response.setContentType("text/html");

			out.println("<h1>Welcome " + e.getFirstName() + "</h1>");
			out.println("<h3>You have successfully logged in <h3>");

			String jsonString = om.writeValueAsString(e);
			out.println(jsonString);
		} else {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("No user found, sorry!");
		}

		// 4 Alternatively you can redirect to another servlet

	}

}

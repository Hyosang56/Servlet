package com.icia.controller.action;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeCheckPassFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/employee/employeeCheckPass.jsp";
	      RequestDispatcher dispatcher = 
	         request.getRequestDispatcher(url);
	      dispatcher.forward(request, response);
		
	}

}

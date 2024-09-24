package com.icia.controller.action;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/employee/employeeWrite.jsp";
	      RequestDispatcher dispatcher = 
	            request.getRequestDispatcher(url);
	      dispatcher.forward(request, response);
		
	}

}

package com.icia.controller.action;

import java.io.IOException;

import com.icia.dao.EmployeeDAO;
import com.icia.dto.EmployeeVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/employee/employeeUpdate.jsp";
	      String id = request.getParameter("id");
	      EmployeeDAO eDao = EmployeeDAO.getInstance();
	      EmployeeVO eVo = eDao.selectOneemployeeById(id);
	      request.setAttribute("employee", eVo);
	      RequestDispatcher dispatcher = 
	            request.getRequestDispatcher(url);
	      dispatcher.forward(request, response);
		
	}

}

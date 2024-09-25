package com.icia.controller.action;

import java.io.IOException;

import com.icia.dao.EmployeeDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
	      EmployeeDAO eDao=EmployeeDAO.getInstance();
	      eDao.deleteEmployee(id);
	      new EmployeeListAction().execute(request, response);
		
	}

}

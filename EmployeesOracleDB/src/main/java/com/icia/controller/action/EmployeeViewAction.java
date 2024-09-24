package com.icia.controller.action;

import java.io.IOException;

import com.icia.dao.EmployeeDAO;
import com.icia.dto.EmployeeVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/employee/employeeView.jsp";
	      String id = request.getParameter("id");
	      EmployeeDAO eDao = EmployeeDAO.getInstance();
//	      eDao.updateReadCount(id);
	      EmployeeVO eVo = eDao.selectOneemployeeById(id);
	      request.setAttribute("employee", eVo);
	      RequestDispatcher dispatcher = 
	            request.getRequestDispatcher(url);
	      dispatcher.forward(request, response);
		
	}

}

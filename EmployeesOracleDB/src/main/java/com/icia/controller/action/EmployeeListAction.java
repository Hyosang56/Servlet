package com.icia.controller.action;

import java.io.IOException;
import java.util.List;

import com.icia.dao.EmployeeDAO;
import com.icia.dto.EmployeeVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/employee/employeeList.jsp";
		EmployeeDAO eDao = EmployeeDAO.getInstance();
	      
	      List<EmployeeVO> employeeList = 
	    		  eDao.selectAllBoards();
	      request.setAttribute("employeeList",
	    		  employeeList);
	      RequestDispatcher dispatcher = 
	      request.getRequestDispatcher(url);
	      dispatcher.forward(request, response);
		
	}

}

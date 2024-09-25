package com.icia.controller.action;

import java.io.IOException;

import com.icia.dao.EmployeeDAO;
import com.icia.dto.EmployeeVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeVO eVo = new EmployeeVO();
		eVo.setId(request.getParameter("id"));
		eVo.setPass(request.getParameter("pass"));
		eVo.setName(request.getParameter("name"));      
		eVo.setLev(request.getParameter("lev"));
		eVo.setGender(request.getParameter("gender"));
		eVo.setPhone(request.getParameter("phone"));
	      EmployeeDAO eDao = EmployeeDAO.getInstance();
	      eDao.updateEmployee(eVo);
	      new EmployeeListAction().execute(request, response);
		
	}

}

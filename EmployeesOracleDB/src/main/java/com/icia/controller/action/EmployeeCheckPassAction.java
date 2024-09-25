package com.icia.controller.action;

import java.io.IOException;

import com.icia.dao.EmployeeDAO;
import com.icia.dto.EmployeeVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeCheckPassAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
	      String id = request.getParameter("id");
	      String pass = request.getParameter("pass");
	      EmployeeDAO eDao = EmployeeDAO.getInstance();
	      EmployeeVO eVo = eDao.selectOneemployeeById(id);
	      if (eVo.getPass().equals(pass)) { // 성공
	         url = "/employee/checkSuccess.jsp";
	      } else {// 실패
	         url = "/employee/employeeCheckPass.jsp";
	         request.setAttribute("message", 
	               "비밀번호가 틀렸습니다.");
	      }
	      RequestDispatcher dispatcher = 
	            request.getRequestDispatcher(url);
	      dispatcher.forward(request, response);
		
	}

}

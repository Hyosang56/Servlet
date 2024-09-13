package com.magic.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;

/**
 * Servlet implementation class MyPageServlet
 */
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getMethod();
		 // GET 요청인 경우 doGet() 메서드 호출
        if (method.equalsIgnoreCase("GET")) {
            doGet(request, response);
        }
        // POST 요청인 경우 doPost() 메서드 호출
        else if (method.equalsIgnoreCase("POST")) {
            doPost(request, response);
        }
        // 그 외의 요청 방식은 필요에 따라 추가 처리
        else {
            // 기본적으로 HttpServlet의 service() 메서드 호출 (GET, POST 이외의 방식에 대응)
            super.service(request, response);
        }
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		EmployeesVO eVo = eDao.getMember(id);
		request.setAttribute("eVo", eVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"mypage.jsp");
		dispatcher.forward(request, response); 
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 한글 깨짐을 방지
	      // 폼에서 입력한 회원 정보 얻어오기
	      String id = request.getParameter("id");
	      String pass = request.getParameter("pass");
	      String name = request.getParameter("name");
	      String lev = request.getParameter("lev");
	      String date = request.getParameter("date");
	      String gender = request.getParameter("gender");
	      String phone = request.getParameter("phone");
	      // 회원 정보를 저장할 객체 생성
	      EmployeesVO eVo = new EmployeesVO();
     	  eVo.setId("id");
     	  eVo.setPass("pass");
     	  eVo.setName("name");
     	  eVo.setLev("lev");
     	  eVo.setDate("date");
     	  eVo.setGender("gender");
     	  eVo.setPhone("phone");
     	 EmployeesDAO eDao = EmployeesDAO.getInstance();
     	 eDao.updateMember(eVo);
	      response.sendRedirect("LoginServlet");
		//doGet(request, response);
	}

}

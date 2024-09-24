package com.icia.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.icia.controller.action.Action;



/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EmployeeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		String command = 
	            request.getParameter("command");
	      System.out.println("BoardServlet에서 요청 받음을 확인="+ 
	            command); 
	      ActionFactory af=ActionFactory.getInstance();
	      Action action=af.getAction(command);
	      if(action != null){
	         action.execute(request, response);
	      }   
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

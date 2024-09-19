package com.magicl.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 방식 확인 (GET 또는 POST)
        String method = request.getMethod();  // GET, POST, PUT, DELETE 등 반환

        /*
         equalsIgnoreCase() 메서드는 자바의 String 클래스에서 제공하는 메서드로, 
         대소문자를 무시하고 두 문자열이 동일한지 비교하는 기능을 제공합니다. 
         즉, 두 문자열을 비교할 때 대소문자 구분을 하지 않고, 동일한 문자 순서로 
         구성되어 있다면 true를 반환하고, 그렇지 않다면 false를 반환합니다.
         */
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
		
		request.setCharacterEncoding("UTF-8");
	      response.setCharacterEncoding("UTF-8");
	      
	      RequestDispatcher rd =
	      request.getRequestDispatcher("login.jsp");
	      rd.forward(request, response);
	    //response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	      response.setCharacterEncoding("UTF-8");
	      
	      String id = request.getParameter("id");
	      String pwd = request.getParameter("pwd");
	      String lev = request.getParameter("lev");
	      String url=null;
	      
	      EmployeesDAO empDAO = EmployeesDAO.getInstance();
	      int result = empDAO.userCheck(id, pwd, lev);
	      //
	      if(result == 2 || result == 3){
	         EmployeesVO emp = new EmployeesVO();
	         emp = empDAO.getMember(id);
	         
	         HttpSession session = request.getSession();
	         session.setAttribute("loginUser", emp);         
	         session.setAttribute("result", result);         
	         url = "main.jsp";            
	      }else{
	         url = "login.jsp";
	         if(result == 1){
	            request.setAttribute("message", "로그인에 실패 했습니다.");
	         }else if(result == 0){         
	            request.setAttribute("message", "비밀번호가 맞지 않습니다.");
	         }else{         
	            request.setAttribute("message", "존재하지 않는 회원입니다.");
	         }
	      }
	      RequestDispatcher rd = request.getRequestDispatcher(url);
	      rd.forward(request, response);
		
		//doGet(request, response);
	}

}

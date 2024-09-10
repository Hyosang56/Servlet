package com.icia.controller;

import java.io.IOException;

import com.icia.DAO.MemberDAO;
import com.icia.vo.MemberVo;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "member/login.jsp";
	      HttpSession session = request.getSession();
	      if (session.getAttribute("loginUser") != null) {// 이미 로그인 된 사용자이면
	         url = "main.jsp"; // 메인 페이지로 이동한다.
	      }
	      
	      RequestDispatcher dispatcher = 
	            request.getRequestDispatcher(url);
	      dispatcher.forward(request, response);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String  url = "member/login.jsp" ;
	      String userid = request.getParameter("userid");
	      String pwd = request.getParameter("pwd");
	      MemberDAO mDao = MemberDAO.getInstance();
	      int result = mDao.userCheck(userid, pwd);
	      if (result == 1) {
	         MemberVo mVo = mDao.getMember(userid);
	         HttpSession session = request.getSession();
	         session.setAttribute("loginUser", mVo);
	         request.setAttribute("message", 
	                  "로그인에 성공했습니다.");
	         url = "main.jsp";
	      } else if (result == 0) {
	         request.setAttribute("message", "비밀번호가 맞지 않습니다.");
	      } else if (result == -1) {
	         request.setAttribute("message", "존재하지 않는 회원입니다.");
	      }

	      RequestDispatcher  dp = 
	         request.getRequestDispatcher(url);
	      dp.forward(request, response) ;
		
		//doGet(request, response);
	}

}

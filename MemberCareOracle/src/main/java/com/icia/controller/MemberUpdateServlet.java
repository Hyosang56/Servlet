package com.icia.controller;

import java.io.IOException;

import com.icia.DAO.MemberDAO;
import com.icia.vo.MemberVo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberUpdateServlet
 */
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 방식 확인 (GET 또는 POST)
        String method = request.getMethod();  
        //GET, POST, PUT, DELETE 등 반환

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

		String userid = 
	            request.getParameter("userid");
	      MemberDAO mDao = MemberDAO.getInstance();
	      MemberVo mVo = mDao.getMember(userid);
	      request.setAttribute("mVo", mVo);
	      RequestDispatcher dispatcher = 
	   request.getRequestDispatcher(
	         "member/memberUpdate.jsp");
	            
	      dispatcher.forward(request, response); 
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 한글 깨짐을 방지
	      // 폼에서 입력한 회원 정보 얻어오기
	      String userid = request.getParameter("userid");
	      String pwd = request.getParameter("pwd");
	      String email = request.getParameter("email");
	      String phone = request.getParameter("phone");
	      String admin = request.getParameter("admin");
	      // 회원 정보를 저장할 객체 생성
	      MemberVo mVo = new MemberVo();
	      mVo.setUserid(userid);
	      mVo.setPwd(pwd);
	      mVo.setEmail(email);
	      mVo.setPhone(phone);
	      mVo.setAdmin(Integer.parseInt(admin));
	      MemberDAO mDao = MemberDAO.getInstance();
	      mDao.updateMember(mVo);
	      response.sendRedirect("LoginServlet");
		  
	      //doGet(request, response);
	}

}

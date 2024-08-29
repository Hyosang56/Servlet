package edu.studentmvc;

import java.io.IOException;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentController
 */
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       StudentDAO dao = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        dao = new StudentDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
	      String action = request.getParameter("action");
	      String view = "";
	      
	      if(action == null) {
	         getServletContext().
	         getRequestDispatcher("/StudentController?action=list").
	         forward(request, response);
	      } else {
	         switch(action) {
	         case "list": view = list(request, response);break;
	         case "insert": view = insert(request, response);break;
	         }
	         getServletContext().
	         getRequestDispatcher("/"+view).
	         forward(request, response);      
	      }
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	public String list(HttpServletRequest request, HttpServletResponse response) {
	      request.setAttribute("students", dao.getAll());
	      return "studentInfo.jsp";      
	   }
	   
	   public String insert(HttpServletRequest request, HttpServletResponse response) {
	      Student s = new Student();
	      try {
	         //BeanUtils.populate(s, request.getParameterMap());
	         //int id = Integer.parseInt(request.getParameter("id"));
	         String username = request.getParameter("username");
	         String univ = request.getParameter("univ");
	         Date birth = Date.valueOf(request.getParameter("birth"));
	         String email = request.getParameter("email");         
	         
	         //s.setId(id); 
	         s.setUsername(username);
	         s.setUniv(univ); 
	         s.setBirth(birth);
	         s.setEmail(email);
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      dao.insert(s);
	      return list(request, response);
	   }	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

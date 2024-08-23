package exam.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CalcServlet
 */
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int n1 = Integer.parseInt(request.getParameter("n1"));
	      int n2 = Integer.parseInt(request.getParameter("n2"));
	      
	      long result = 0;
	      
	      switch(request.getParameter("op")) {
	         case "+": result = n1+n2;break;
	         case "-": result = n1-n2;break;
	         case "/": result = n1/n2;break;
	         case "*": result = n1*n2;break;
	      }
	      
	      response.setContentType("text/html; charset=utf-8");
	      //PrintWriter는 개체의 형식화된 표현을 텍스트 출력 스트림에 출력한다.
	      PrintWriter out = response.getWriter();
	      out.append("<html><body><h1>계산기 서블릿</h1><hr>")
	      .append("<h1>계산 결과: "+result+"</h1></body></html>");
		
		doGet(request, response);
	}

}

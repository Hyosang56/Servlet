package edu.product;

import java.io.IOException;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductController
 */
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO dao = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        dao = new ProductDAO();
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
	         getRequestDispatcher("/ProductController?action=list").
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
	      request.setAttribute("products", dao.getAll());
	      return "productInfo.jsp";      
	   }
	   
	   public String insert(HttpServletRequest request, HttpServletResponse response) {
		   Product p = new Product();
	      try {
	         //BeanUtils.populate(s, request.getParameterMap());
	         //int id = Integer.parseInt(request.getParameter("id"));
	         String name = request.getParameter("name");
	         String maker = request.getParameter("maker");
	         int price = Integer.parseInt(request.getParameter("price"));
	         Date makedate = Date.valueOf(request.getParameter("makedate"));
	         
	         //s.setId(id); 
	         
	         p.setName(name); 
	         p.setMaker(maker);
	         p.setPrice(price);
	         p.setMakedate(makedate);
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      dao.insert(p);
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

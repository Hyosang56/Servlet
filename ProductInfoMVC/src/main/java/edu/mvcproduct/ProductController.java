package edu.mvcproduct;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ProductController
 */
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		ProductService service = null;
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        service = new ProductService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
	      String view = "";
	      
	      if(action == null) {
	         getServletContext().
	         getRequestDispatcher("/ProductController?action=list").
	         forward(request, response);
	      }
	      else
	      {
	         switch(action)
	         {
	            case "list" :
	               view = list(request, response); 
	               break;
	            case "info":
	               view = info(request, response);
	               break;
	         }//end of switch
	         getServletContext().
	         getRequestDispatcher("/" + view).
	         forward(request, response);
	      }
		response.getWriter().append("Served at: ").append(request.getContextPath());	
	}
	private String info(HttpServletRequest request, HttpServletResponse response) 
	   {
	      request.setAttribute("p", service.find(request.getParameter("id")));
	      return "productInfo.jsp";
	   }
	    
	    private String list(HttpServletRequest  request,
	             HttpServletResponse response)
	    {
	       request.setAttribute("products",
	                service.findAll() );
	       return  "productList.jsp" ;
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

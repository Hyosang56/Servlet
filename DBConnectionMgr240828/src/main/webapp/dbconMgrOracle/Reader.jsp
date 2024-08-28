<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="DBError.jsp" %>

<%@ page import="webdb.jdbcex.DBConnectionMgrOracle" %>
<%@ page  import="java.sql.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 정보를 GoodInfo테이블에 연결</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
		    String code = request.getParameter("code");
		    int mycode = Integer.parseInt(
		    		request.getParameter("code"));	    
		    
		    if (code == null)
		        throw new Exception("상품코드를 입력하십시오.");
		    
		    DBConnectionMgrOracle  pool =
			DBConnectionMgrOracle.getInstance();
		    
		    Connection conn = null;
		    Statement stmt = null;
		    int counter = 0 ;
		    try {
		         //Class.forName("oracle.jdbc.driver.OracleDriver");
		        //conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" ,"scott", "tiger");
		        
		        conn = pool.getConnection();
				stmt = conn.createStatement();

		        if (conn == null)
		            throw new Exception(
	            		"데이터베이스에 연결할 수 없습니다.");
		        
		        stmt = conn.createStatement();
		        ResultSet rs = stmt.executeQuery(
	"select * from goodsinfo where code = '" + code + "'");
		        if (!rs.next())
		            throw new Exception("상품코드(" + code + ")에 해당하는 데이터가 없습니다.");
		        
		        String title = rs.getString("title");
		        String writer = rs.getString("writer");
		        int price = rs.getInt("price");
		        
		        /*
		        out.println("<h1> code =" + code + "</h1>");
				out.println("<h1> title =" + title + "</h1>");
				out.println("<h1> writer =" + writer + "</h1>");
				out.println("<h1> price =" + price + "</h1>");
				*/
		
		        
		        request.setAttribute("CODE", code);
		        request.setAttribute("TITLE", title);
		        request.setAttribute("WRITER", writer);
		        request.setAttribute("PRICE", 
		        			new Integer(price));
		       
		    }
		    finally {
		        try { 
		            stmt.close();
		        } 
		        catch (Exception ignored) {
		        }
		        try { 
		            conn.close();
		        } 
		        catch (Exception ignored) {
		        }
		    }
		      
		    RequestDispatcher dispatcher = 
	   	request.getRequestDispatcher("EditForm.jsp");
		    dispatcher.forward(request, response);
	%>	
</body>
</html>

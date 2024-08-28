<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="webdb.jdbcex.DBConnectionMgr" %>
<%@ page import="java.sql.*" %>    
    
<%
	DBConnectionMgr  pool =
			DBConnectionMgr.getInstance();
	
	Connection  conn = null;
	Statement  stmt = null ;
	ResultSet  rs = null;
	
	String  code, title, writer;
	int  price = 0;
	
	int mycode = Integer.parseInt(
		request.getParameter("code"));
	
	int counter = 0 ;
	try{
		
		conn = pool.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(
"select * from goodsinfo where code= '" + mycode + "';") ;
		
		if(!rs.next())
		{ throw new Exception("해당상품이 없음"); }
		
		code = rs.getString("code");
		title = rs.getString("title");
		writer = rs.getString("writer");
		price = rs.getInt("price");
		
		out.println("<h1> code =" + code + "</h1>");
		out.println("<h1> title =" + title + "</h1>");
		out.println("<h1> writer =" + writer + "</h1>");
		out.println("<h1> price =" + price + "</h1>");		
	}
	catch(SQLException sqlException){
		  System.out.println("sql exception");
	 }catch(Exception exception){
	    System.out.println("exception");
	 }finally{
	   if( rs != null ) 
	         try{ rs.close(); } 
	         catch(SQLException ex) {}
	      if( stmt != null ) 
	         try { stmt.close(); } 
	         catch(SQLException ex) {}   
	 }	
	
%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DBConnection Pool 연습</title>
</head>
<body>
	<H1>JSP 스크립틀릿에서 Connection Pool을 
		이용한 데이터베이스 연동 예제</H1>
</body>
</html>
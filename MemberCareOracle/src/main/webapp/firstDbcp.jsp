<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.sql.Connection" %>
   <%@ page import="javax.sql.DataSource" %>
   <%@ page import="javax.naming.Context" %>
   <%@ page import="javax.naming.InitialContext" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>데이터베이스 커넥션 풀 테스트</h1>
	<%
   Context initContext = new InitialContext();
   Context envContext  = (Context)initContext.lookup("java:/comp/env");
   DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
   Connection conn = ds.getConnection();
   
   out.println("<h2>DBCP 연동 성공</h2>");
   %>
</body>
</html>
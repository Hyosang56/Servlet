<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.icia.DAO.MemberDAO"  %>
    <%@ page import="java.sql.Connection"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
      MemberDAO  memDao = MemberDAO.getInstance();
      Connection
      conn = memDao.getConnection();
      
      out.println ("<h1>DBCP 연결 성공-두번째</h1>");
   %>
</body>
</html>
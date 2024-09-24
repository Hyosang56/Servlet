<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp 문제</title>
</head>
<body>
	<% 
   response.sendRedirect(
"http://localhost:8085/EmployeesOracleDB/EmployeeServlet?command=employee_list");
%>
</body>
</html>
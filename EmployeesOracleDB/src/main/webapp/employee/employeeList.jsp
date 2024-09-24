<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employeeList.jsp</title>
<link rel="stylesheet" type="text/css" href="css/design.css">
</head>
<body>
	<div id="wrap" align="center">
      <h1>리스트</h1>
      <table class="list">
         <tr>
            <td colspan="5" style="border: white; text-align: right">
            <a   href="EmployeeServlet?command=employee_write_form">정보 등록</a></td>
         </tr>
         <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>권한</th>
            <th>성별</th>
            <th>전화번호</th>
         </tr>
         <c:forEach var="employee" items="${employeeList}">
            <tr class="record">
               <td>${employee.id }</td>
               <td><a href="EmployeeServlet?command=employee_view&id=${employee.id}">
                     ${employee.name } </a></td>
               <td>${employee.lev}</td>
               <td>${employee.gender}</td>
               <td>${employee.phone}</td>
            </tr>
         </c:forEach>
      </table>
   </div>
</body>
</html>
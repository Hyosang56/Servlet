<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employeeView.jsp</title>
<link rel="stylesheet" type="text/css"
    href="css/design.css">
<script type="text/javascript" 
      src="script/employee.js"></script>
</head>
<body>
	<div id="wrap" align="center">
      <h1>정보 보기</h1>
      <table>
         <tr>
            <th>아이디</th>
            <td>${employee.id}</td>
         </tr>
         <tr>
         	<th>비밀번호</th>
            <td>${employee.pass}</td>
         </tr>
         <tr>
         	<th>이름</th>
            <td>${employee.name }</td>
         </tr>
         <tr>
            <th>권한</th>
            <td>${employee.lev }</td>
         </tr>
         <tr>
            <th>성별</th>
            <td>${employee.gender }</td>
         </tr>
         <tr>
            <th>전화번호</th>
            <td>${employee.phone }</td>
         </tr>
         <tr>
            <th>가입일</th>
            <td><fmt:formatDate value="${employee.enter}" /></td>   
         </tr>
      </table>
      <br> <br> 
      <input type="button" value="수정"
         onclick="open_win('EmployeeServlet?command=employee_check_pass_form&id=${employee.id}', 'update')">
      <input type="button" value="삭제"
         onclick="open_win('EmployeeServlet?command=employee_check_pass_form&id=${employee.id}', 'delete')">
      <input type="button" value="목록"
         onclick="location.href='BoardServlet?command=employee_list'"> 
      <input type="button" value="등록"
         onclick="location.href='BoardServlet?command=employee_write_form'">
   </div>
</body>
</html>
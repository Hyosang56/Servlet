<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>employeeUpdate.jsp</title>
<link rel="stylesheet" type="text/css" 
	href="css/design.css">

<script type="text/javascript" 
		src="script/employee.js"></script>
</head>
<body>
	<div id="wrap" align="center">
      <h1>정보 수정</h1>
      <form name="frm" method="post" 
         action="/EmployeesOracleDB/EmployeeServlet">
         <input type="hidden" name="command" 
               value="employee_update">
         <table>
            <tr>
               <th>아이디</th>
               <td><input type="text" name="id" value="${employee.id}"> * 필수</td>
            </tr>
            <tr>
               <th>비밀번호</th>
               <td><input type="password" name="pass" value="${employee.pass}"> * 필수 </td>
            </tr>
            <tr>
               <th>이름</th>
               <td><input type="text" name="name" value="${employee.name}"></td>
            </tr>
            <tr>
               <th>권한</th>
               <td>
               		<select name="lev">
               			<option value = "A">운영자</option>
               			<option value = "B">일반사용자</option>
               		</select>
               </td>
            </tr>
            <tr>
               <th>성별</th>
               <td>
               		<select name="gender">
               			<option value = "1">남자</option>
               			<option value = "2">여자</option>
               		</select>
               </td>
            </tr>
            <tr>
               <th>전화번호</th>
               <td><input type="text" name="phone" value="${employee.phone}"></td>
            </tr>
      
         </table>
         <br>
         <br> <input type="submit" value="확인"
            onclick="return employeeCheck()"> <input type="reset"
            value="취소"> <input type="button" value="목록"
            onclick="location.href='EmployeeServlet?command=employee_list'">
      </form>
   </div>
</body>
</html>
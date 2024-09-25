<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employeeCheckPass.jsp</title>
<link rel="stylesheet" 
   href="css/design.css">
<script type="text/javascript" src="script/employee.js"></script>
</head>
<body>
	<div align="center">
      <h1>비밀번호 확인</h1>
      <form action="/EmployeesOracleDB/EmployeeServlet" 
      name="frm" method="get">
         <input type="hidden" name="command" 
            value="employee_check_pass">
         <input type="hidden" name="id" 
            value="${param.id}">
         <table style="width: 80%">
            <tr>
               <th>비밀번호</th>
               <td><input type="password" 
               name="pass" size="20"></td>
            </tr>
         </table>
         <br> <input type="submit" value=" 확 인 "
            onclick="return passCheck()"> <br>
         <br>${message}
      </form>
   </div>
</body>
</html>
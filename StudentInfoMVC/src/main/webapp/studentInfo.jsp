<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sutdentInfo.jsp 학생정보 출력</title>
</head>
<body>
	<H1>학생 정보</H1>
   [ <a href="/StudentInfoMVC/StudentController">새로고침</a>]  
   <hr>
   <table border="1">
      <tr><th>id</th><th>이름</th>
      <th>대학</th><th>생일</th><th>이메일</th></tr>
      <c:forEach items="${students}" var ="s">
         <tr>
            <td>${s.id}</td>
            <td>${s.username}</td>
            <td>${s.univ}</td>
            <td>${s.birth}</td>
            <td>${s.email}</td>
         </tr>      
      </c:forEach>
   </table>
   
   <hr>
   
   <h2>학생 추가</h2>
   <hr>
   <form method="post" action="/StudentInfoMVC/StudentController?action=insert">
      <label>이름</label>
      <input type="text" name="username"><br>
      <label>대학</label>
      <input type="text" name="univ"><br>
      <label>생일</label>
      <input type="text" name="birth"><br>
      <label>이메일</label>
      <input type="text" name="email"><br>
      <button type="submit">등록</button>
   </form>
</body>
</html>
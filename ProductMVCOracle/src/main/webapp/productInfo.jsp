<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H1>상품 목록</H1>
	[ <a href="/ProductMVCOracle/ProductController">새로고침</a>]
	<hr>
   <table border="1">
      <tr><th>번호</th><th>상품명</th>
      <th>브랜드</th><th>가격</th></tr>
      <c:forEach items="${products}" var ="p">
         <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.maker}</td>
            <td>${p.price}</td>
         </tr>      
      </c:forEach>
   </table>
   
   <hr>
   
   <h2>상품 추가</h2>
   <hr>
   <form method="post" action="/ProductMVCOracle/ProductController?action=insert">
      <label>번호</label>
      <input type="text" name="id"><br>
      <label>상품명</label>
      <input type="text" name="name"><br>
      <label>브랜드</label>
      <input type="text" name="maker"><br>
      <label>가격</label>
      <input type="text" name="price"><br>
      <button type="submit">등록</button>
   </form>
</body>
</html>
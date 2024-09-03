<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gugudan.jsp</title>
</head>
<body>
	<h2>구구단 단수 입력하시오.</h2>
	<form method="post" action="/GugudanMVC/Controller">
      <h2><p>구구단: <input type="text" name="number"></h2>
      <p><input type="submit" value="전송">
   </form>
</body>
</html>
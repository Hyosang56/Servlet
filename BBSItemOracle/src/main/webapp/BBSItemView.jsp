<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="CommonError.jsp" %>
    
<jsp:useBean id="bbsItem" class="web.oracleex.BBSItem" />
<jsp:setProperty name="bbsItem" property="seqNo" value="${param.SEQ_NO}" />
<% bbsItem.readDB(); %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 읽기3</title>
</head>
<body>
	<H2>게시글 읽기3</H2>
	[제목] ${bbsItem.title} <BR>
	[작성자] ${bbsItem.writer} 
	[작성일시] ${bbsItem.date} ${bbsItem.time} <BR>
	------------------------------------------------------------ <BR>
	${bbsItem.content}
</body>
</html>
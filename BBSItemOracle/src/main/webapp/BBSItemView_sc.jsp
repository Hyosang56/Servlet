<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="CommonError.jsp" %>
<%@page import ="web.oracleex.BBSItem"%>
<%
    int seqNo = Integer.parseInt(request.getParameter("SEQ_NO"));
    BBSItem bbsItem = new BBSItem();
    bbsItem.setSeqNo(seqNo);
    bbsItem.readDB();
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 읽기</title>
</head>
<body>
	<H4>게시글 읽기</H4>	
        [제목] <%= bbsItem.getTitle() %> <BR>
        [작성자] <%= bbsItem.getWriter() %>
        [작성일시] <%= bbsItem.getDate() %> <%= bbsItem.getTime() %> <BR>
        ------------------------------------------------------------ <BR>
      	<%= bbsItem.getContent() %>
</body>
</html>
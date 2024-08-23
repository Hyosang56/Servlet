<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean  id="bbsItemOB" class="com.webdb.BBSItem" />    
<jsp:setProperty  name="bbsItemOB" property="seqNo" 
					value="${param.SEQ_NO}" />

<%
	bbsItemOB.readDB();
%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BBSItemView_sa.jsp 파일</title>
</head>
<body>
	<H1>bbs 게시판 글 읽어오기</H1>
	[제목]<jsp:getProperty  name ="bbsItemOB" 
			property="title" /> <br>
	[작성자] <jsp:getProperty name="bbsItemOB" 
			property="writer" /> <br>
	[작성일시] <jsp:getProperty name="bbsItemOB" 
			property="date" /> <br>
	<br/>
	[글내용]<jsp:getProperty name="bbsItemOB"
			property="content" /> <br>
	-----------------------------------
	<h2>게시글 읽기-두번째 방법</h2>
		[제목] ${bbsItemOB.title}<br>
		[작성자] ${bbsItemOB.writer}<br>
		[작성일시] ${bbsItemOB.date}
				{bbsItemOB.time}<br>
		[글내용] ${bbsItemOB.content}
</body>
</html>







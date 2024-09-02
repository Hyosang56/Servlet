<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 - BBSListView.jsp 파일</title>
</head>
<body>
	<H2>게시판 목록 보기</H2>
        <TABLE border=1>
            <TR>
                <TD width=40>순번</TD>
                <TD width=300>제목</TD>
                <TD width=80>작성자</TD>
                <TD width=90>작성일자</TD>
                <TD width=70>작성시각</TD>
            </TR>
            <c:forEach var="cnt" begin="0"
            end="${BBS_LIST.listSize -1 }">
            <tr>
            	<td>${BBS_LIST.seqNo[cnt]}</td>
            	<TD>${BBS_LIST.title[cnt]}</TD>
                <TD>${BBS_LIST.writer[cnt]}</TD>
                <TD>${BBS_LIST.date[cnt]}</TD>
                <TD>${BBS_LIST.time[cnt]}</TD>
            </tr>
            </c:forEach>
            </TABLE>
            <c:if test ="${!BBS_LIST.lastPage}">
            <A href='/BBSListOracle/BBSListServlet?LAST_SEQ_NO=${BBS_LIST.seqNo[
                          BBS_LIST.listSize - 1]}'>다음 페이지</A>
            </c:if>
</body>
</html>
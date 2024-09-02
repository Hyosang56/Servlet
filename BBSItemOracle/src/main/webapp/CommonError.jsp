<%@page contentType="text/html; charset=UTF-8" isErrorPage="true" %>
<% response.setStatus(200); %>
<HTML>
    <HEAD><TITLE>에러 페이지</TITLE></HEAD>
    <BODY>
    <H4>에러 발생</H4>
    에러 메시지: <%= exception.getMessage() %>
    </BODY>
</HTML>

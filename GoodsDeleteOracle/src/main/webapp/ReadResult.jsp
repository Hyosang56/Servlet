<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H2> 삭제 버튼을 누르면 상품정보 삭제됨</H2>
   <FORM ACTION=Deleter.jsp METHOD=POST>
   코드:<INPUT TYPE=TEXT NAME=code SIZE=5 
      VALUE='${CODE}' READONLY=TRUE><BR>
   제목:<INPUT TYPE=TEXT NAME=title SIZE=50 
        VALUE='${TITLE}' READONLY=TRUE><BR>
   저자: <INPUT TYPE=TEXT NAME=writer SIZE=20
      VALUE='${WRITER}' READONLY=TRUE><BR>
   가격: <INPUT TYPE=TEXT NAME=price SIZE=8
      VALUE='${PRICE}' READONLY=TRUE><BR>
      <INPUT TYPE=SUBMIT VALUE='삭제'>
      <INPUT TYPE=REST VALUE='취소'>
   </FORM>
</body>
</html>
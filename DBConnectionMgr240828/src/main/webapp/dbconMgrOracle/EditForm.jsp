<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 정보 관리</title>
</head>
<body>
	<H4>상품 정보를 수정한 후 수정 버튼을 누르십시오.</H4>
        <FORM ACTION=Updater.jsp METHOD=POST>
            코드: <INPUT TYPE=TEXT NAME=code SIZE=5 VALUE='${CODE}' READONLY=TRUE> <BR>
            제목: <INPUT TYPE=TEXT NAME=title SIZE=50 VALUE='${TITLE}'> <BR>
            저자: <INPUT TYPE=TEXT NAME=writer SIZE=20 VALUE='${WRITER}'> <BR>
            가격: <INPUT TYPE=TEXT NAME=price SIZE=8 VALUE='${PRICE}'>원 <BR>
            <INPUT TYPE=SUBMIT VALUE='수정'>
        </FORM>
</body>
</html>
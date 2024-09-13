<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<script type = "text/javascript" src = "script/oracle.js"></script>
<style>
	table {
        border-collapse: collapse;
    }
    th {
        border: 1px solid black;
    }
    .center-table {
        margin: 20px auto; /* 테이블 사이에 20px 여백을 추가하고, 가운데 정렬 */
    }
</style>
</head>
<body>
<form action="/EmployeesOracle/LoginServlet" method="post" name="frm">
	<table>
		<tr>
			<th width="200" height="10"></th>
			<th width="200" height="10"></th>
			<th width="200" height="10">로그인</th>
			<th width="200" height="10">사원등록<br>(관리자로 로그인 후 사용 가능)</th>
			<th width="200" height="10">마이페이지<br>(로그인 후 사용 가능)</th>
		</tr>
	</table>
	<table class = "center-table">
		<tr>
			<th width = "150" colspan="2">로그인</th> 
		</tr>
		<tr>
			<th width = "150">아이디</th>
			<th width = "150"><input id="id" name="id" type="text"></th>
		</tr>
		<tr>
			<th width = "150">비밀번호</th>
			<th width = "150"><input id="pass" name="pass" type="password"></th>
		</tr>
		<tr>
			<th width = "150">레벨</th>
			<th width = "150">
			<select name="lev">
				<option>운영자</option>
				<option>일반회원</option>		
			</select></th>
		</tr>
		<tr>
			<th width = "150" colspan="2">
				<input type="submit" value="로그인" onclick="return loginCheck()">&nbsp;&nbsp;
				<input type="reset" value="취소">
			</th> 
		</tr>
	</table>
	</form>
</body>
</html>
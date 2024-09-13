<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mypage.jsp</title>
<script type="text/javascript" src="script/oracle.js"></script>
<style>
	table {
        border-collapse: collapse;
    }
    th {
        border: 1px solid black;
    } 
    /* 가운데 정렬을 위한 스타일 */
    .center-content {
        text-align: center; /* 텍스트 중앙 정렬 */
        margin: 20px auto; /* 테이블 및 요소 중앙 정렬 */
    }
    .center-table {
        margin: 20px auto; /* 테이블 사이에 20px 여백을 추가하고, 가운데 정렬 */
    }
</style>
</head>
<body>
		<form action= "/EmployeesOracle/MyPageServlet"
		 method="post" name="frm">
	<table>
		<tr>
			<th width="200" height="10">${loginUser.name}님 반갑습니다.</th>
			<th width="200" height="10">레벨: ${loginUser.lev}</th>
			<th width="200" height="10">
			<a href="/EmployeesOracle/LogoutServlet">로그아웃</a>
			</th>
			<th width="200" height="10">
			<a href="/EmployeesOracle/RegisterServlet" onclick="return ${loginUser.lev == 'A'}">사원등록</a>
			</th>
			<th width="200" height="10">
			<a href="/EmployeesOracle/MyPageServlet">마이페이지</a>
			</th>
		</tr>
	</table>
	<table class = "center-table">
		<tr>
			<th width = "150" colspan="2">마이페이지</th> 
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
			<th width = "150">이름</th>
			<th width = "150"><input id="name" name="name" type="text"></th>
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
			<th width = "150">성별</th>
			<th width = "150">
			<select name="gender">
				<option>남자</option>
				<option>여자</option>		
			</select></th>
		</tr>
		<tr>
			<th width = "150">전화번호</th>
			<th width = "150"><input id="phone" name="phone" type="text"></th>
		</tr>
		<tr>
			<th width = "150" colspan="2">
				<input type="submit" value="수정" onclick="return joinCheck()">&nbsp;&nbsp;
				<input type="reset" value="취소">
			</th> 
		</tr>
	</table>
	
	</form>
</body>
</html>
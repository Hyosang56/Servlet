<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
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
    /* 이미지 크기를 조정하고 중앙 정렬 */
    .center-image {
        display: block;
        margin: 20px auto;
        width: 50%; /* 이미지 크기 50%로 조정 */
        height: auto; /* 비율 유지하면서 크기 조정 */
    }
</style>
</head>
<body>
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
	<h2 class="center-content">회원 전용 페이지</h2>
	<tr>
		<img src="image/yuna.jpg" alt="김연아" class="center-image"/>
	</tr>
</body>
</html>
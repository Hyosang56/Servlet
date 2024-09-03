<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="dbconn.jsp" %>
<%
	request.setCharacterEncoding("utf-8");

	String before_depart = request.getParameter("before_depart");
	String after_depart = request.getParameter("after_depart");
	
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	try {
		String sql = "select * from student3 where depart = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, before_depart);
        rs = pstmt.executeQuery();

        if (rs.next()) {
           String depart = rs.getString("depart");
           
           if (before_depart.equals(depart)) {

		sql = "update student3 set depart= ? where depart=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, after_depart);
		pstmt.setString(2, before_depart);

		pstmt.executeUpdate();
		out.println("Student 테이블을 수정했습니다.");
        } else
   	   out.println("Student 테이블을 수정하지 못했습니다.");
        } else
        out.println("Student 테이블에 일치하는 학과가 없습니다.");

	} catch (SQLException ex) {
		out.println("SQLException: " + ex.getMessage());
	} finally {
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	}
%>
</body>
</html>
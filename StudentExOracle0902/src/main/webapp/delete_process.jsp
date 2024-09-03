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

	String depart = request.getParameter("depart");
	
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	try {
		String sql = "select * from student3 where depart = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, depart);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String depart_select = rs.getString("depart");
        
           
        if (depart_select.equals(depart)) {

		sql = "delete from student3 where depart= ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,depart);
		
		pstmt.executeUpdate();
		out.println("해당 학과를 삭제했습니다.");
        } else
   	   out.println("해당 학과를 삭제하지 못했습니다.");
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
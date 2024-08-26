<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>itemWrite.jsp 파일</title>
</head>
<body>
	<h2>입력 완료된 정보</h2>
<%
try{
   String url="jdbc:oracle:thin:@localhost:1521:XE";
   String uid="madang";
   String pass="madang";
   String sql = "SELECT * FROM item";
   
   Connection conn = null;
   Statement stmt = null;
   ResultSet rs = null;
   Class.forName("oracle.jdbc.driver.OracleDriver");
   System.out.println("드라이버 로딩 성공");
   conn = DriverManager.getConnection(url, uid, pass);
   System.out.println("연결 성공");
   stmt = conn.createStatement();
   rs = stmt.executeQuery(sql);
   
   out.println("<table border=1>");
   while(rs.next())
   {
      out.println("<tr>");
      out.println("<td>"+
         rs.getString("name")+"</td>");
      out.println("<td>"+rs.getString("price")+"</td>");
      out.println("<td>"+
         rs.getString("description")+"</td>");
      out.println("</tr>");
   }
   out.println("</table>");
}catch(Exception e){
   e.printStackTrace();
}
%>
</body>
</html>
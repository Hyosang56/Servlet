<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
	try{
   String url="jdbc:oracle:thin:@localhost:1521:XE";
   String uid="madang";
   String pass="madang";
   String sql = "SELECT * FROM EMPLOYEE";
   
   Class.forName("oracle.jdbc.driver.OracleDriver");
   System.out.println("드라이버 로딩 성공");
   
   conn = DriverManager.getConnection(url, uid, pass);
   System.out.println("연결 성공");
   
   stmt = conn.createStatement();
   rs = stmt.executeQuery(sql);
   System.out.println("쿼리 실행 성공");
   
   out.println("<table border=1>");
   while(rs.next())
   {
      out.println("<tr>");
      out.println("<td>"+rs.getString("NAME")+"</td>");
      out.println("<td>"+rs.getString("ADDRESS")+"</td>");
      out.println("<td>"+rs.getString("SSN")+"</td>");
      out.println("</tr>");
   }
   out.println("</table>");
}catch(Exception e){
   e.printStackTrace();
   out.println("에러 발생:"+e.getMessage());
} finally {
	if(rs!= null)
		rs.close();
     if(conn!= null)
        conn.close();
     if(stmt!= null)
    	 stmt.close();
}
%>
</body>
</html>
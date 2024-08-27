<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
      request.setCharacterEncoding("UTF-8");
      //response.setContentType("text/html; charset=UTF-8");//이 프로그램에서는 response객체를 사용안하므로로 없어도 됨.
      String name = request.getParameter("name");
       String id = request.getParameter("id");
       String password = request.getParameter("password");
       if (name == null || id == null || password == null) 
           throw new Exception("데이터를 입력하십시오.");
       Connection conn = null;
       Statement stmt = null;
       try {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
               "madang", "madang");           
          
           if (conn == null)
               throw new Exception("데이터베이스에 연결할 수 없습니다.");
           stmt = conn.createStatement();
         String sql = String.format("insert into userinfo(name, id, password) values('%s','%s','%s')",
        		 					name,id,password);
         int rowNum = stmt.executeUpdate(sql);
         if(rowNum < 1)
        	 throw new Exception("데이터를 DB에 입력 불가");
       }
         finally {
             try { 
                 stmt.close();
             } 
             catch (Exception ignored) {
             }
             try { 
                 conn.close();
             } 
             catch (Exception ignored) {
             }
         }
       
       response.sendRedirect("RegisterResult.jsp");
           %>
</body>
</html>
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
      String code =
        request.getParameter("code");
      if(code == null)
         throw new Exception("상품코드 입력필");
      Connection conn = null ;
      Statement stmt = null;
      
      try{      
         Class.forName(
      "oracle.jdbc.driver.OracleDriver");
           conn = DriverManager.getConnection(
         "jdbc:oracle:thin:@localhost:1521:xe",
               "madang", "madang");
           if(conn == null)
              throw new Exception("DB연결 실패");
           stmt = conn.createStatement();
           ResultSet rs =stmt.executeQuery(
              "select* from goodsinfo where code='"+code+"'");
           
           if(!rs.next())    
              throw new Exception("해당 상품 없음");
           
           String title = rs.getString("title") ;
           String writer =rs.getString("writer") ;
           int price = rs.getInt("price");
           request.setAttribute("CODE", code);
           request.setAttribute("TITLE", title);
           request.setAttribute("WRITER", writer);
           request.setAttribute("PRICE", new Integer(price) );
           
      }
      catch(Exception e)
      {  out.println(e.getMessage()) ; }
      finally{
         try{
            stmt.close(); conn.close();
         }
         catch(Exception e)
         {  out.println(e.getMessage()) ; }
      }
      
      RequestDispatcher dis =
   request.getRequestDispatcher("ReadResult.jsp");
      dis.forward(request, response);
      
   %>
</body>
</html>
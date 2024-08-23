<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%
   String code = request.getParameter("code");
   String title = request.getParameter("title");
   String writer = request.getParameter("writer");
   String price = request.getParameter("price");
   
   if(code == null || title==null || writer==null ||
         price == null)
      throw new Exception("누락된 데이터가 있습니다.");
   
   Connection  conn = null;
   Statement  stmt = null ;
   
   try{
      Class.forName("com.mysql.cj.jdbc.Driver") ;
      conn=DriverManager.getConnection(
   "jdbc:mysql://localhost:3306/webdb?useSSL=false&serverTimezone=Asia/Seoul", "root","1234");
      
      if(conn == null)
         throw new Exception("데이터베이스에 연결 불가");
      
      stmt = conn.createStatement();
      String command = String.format(
   "update goodsinfo set"+"title='%s',writer='%s'"+
      "price = '%s' where code = '%s';",
      title, writer, price,code);
      
      int rowNum = stmt.executeUpdate(command);
      if(rowNum < 1)
          throw new Exception("데이터를 DB에 입력 불가");   
    
    }//end of try
    finally{
       try{
          stmt.close();
       }
       catch(Exception  ignored){  }
       try{
          conn.close();
       }
       catch(Exception  ignored){ }
    }
    response.sendRedirect("updateResult.jsp?code="+code);
      %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
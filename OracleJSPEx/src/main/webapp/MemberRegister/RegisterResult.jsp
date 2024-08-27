<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page  import="java.sql.*" %>    
    
<%!
   Connection  conn = null;
   Statement stmt = null;
   PreparedStatement pstmt = null;
   ResultSet  rs = null ;
   String url = "jdbc:oracle:thin:@localhost:1521:xe" ;
   String uid = "madang";
   String pass = "madang";
   String sql = "select * from userinfo" ;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<H3>회원 가입 결과</H3>
        가입되었습니다.
        <table width='300' border='1'>
      <tr>
         <th>이름</th>
         <th>아이디</th>
         <th>암호</th>
      </tr>
       <% 
      try{
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
        		 "madang", "madang");
         stmt = conn.createStatement();
         rs = stmt.executeQuery(sql);
         
         while(rs.next())
         {
            out.println("<tr>");
            out.println("<td>" + rs.getString("name") + "</td>" ); 
            out.println("<td>" + rs.getString("id") + "</td>" );
            out.println("<td>" + rs.getString("password") + "</td>" );
      
            out.println("</tr>");
         }//end of while(rs.next())
      }//end of try{ }
      catch(Exception e){
         e.printStackTrace();
      }
      finally
      {
         try{ 
            if(rs != null)  rs.close() ;
            if(stmt != null) stmt.close();
            if(conn != null)  conn.close();
         }
         catch(Exception  e){
            e.printStackTrace();
         }
      }//end of finally
         
      %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import= "java.sql.*" %>    
    
<%! //선언문태그의 내용은 첫 방문자에 의해서 단 한번만 수행됨.

   Connection  conn = null;
   Statement stmt = null;
   ResultSet  rs = null ;
   String url = "jdbc:oracle:thin:@localhost:1521:xe" ;
   String uid = "scott";
   String pass = "tiger";
   String  sql = "select * from member" ;
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width='800' border='1'>
      <tr>
         <th>이름</th>
         <th>아이디</th>
         <th>암호</th>
         <th>이메일</th>
         <th>전화번호</th>
         <th>권한(1:관리자, 2:일반회원)</th>
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
            out.println("<td>" + rs.getString("userid") + "</td>" );
            out.println("<td>" + rs.getString("pwd") + "</td>" );
            //email, phone, admin필드 출력하는 코드 작성
            out.println("<td>" + rs.getString("email") + "</td>");
            out.println("<td>" + rs.getString("phone") + "</td>");
            out.println("<td>" + rs.getInt("admin") + "</td>");
            
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
      
   </table>
</body>
</html>
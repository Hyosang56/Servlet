<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
      request.setCharacterEncoding("utf-8");
      String strEMPNO = 
            request.getParameter("EMPNO");
      Connection  conn = null;
      Statement  stmt = null;
      
      try{
         Class.forName(
         "oracle.jdbc.driver.OracleDriver");
conn = DriverManager.getConnection(
      "jdbc:oracle:thin:@localhost:1521:xe",
      "madang", "madang");
         if(conn == null)
            throw new Exception("데이터베이스 연결불가<br>");
         
         stmt = conn.createStatement();
         ResultSet  rs = 
               stmt.executeQuery("select * from EMP where EMPNO = '" + strEMPNO + "'");
         
         if(rs.next())
         {
            int empno = rs.getInt("EMPNO");
            String ename = rs.getString("ENAME");
            String job = rs.getString("JOB");
            Date  date = rs.getDate("HIREDATE");
            int deptno = rs.getInt("DEPTNO");
            int comm = rs.getInt("COMM");
            
            request.setAttribute("SEMPNO", empno);
            request.setAttribute("SENAME", ename);
            request.setAttribute("SJOB", job);
            request.setAttribute("SDATE", date);
            request.setAttribute("SDEPTNO", deptno);
            request.setAttribute("SCOMM", comm);
         }
      } //end of try{ }
      finally
      {
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
      }//end of finally{ }
      
      RequestDispatcher  disp = 
    	      request.getRequestDispatcher("EMPInfoViewer.jsp");
    	         disp.forward(request, response);
      
      %>
</body>
</html>
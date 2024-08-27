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
      response.setContentType("text/html; charset=UTF-8");
       String code = request.getParameter("code");
       if (code == null)
           throw new Exception("상품코드를 입력하십시오.");
       Connection conn = null;
       Statement stmt = null;
       try {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                  "madang", "madang");
           if (conn == null)
               throw new Exception("데이터베이스에 연결할 수 없습니다.");
           stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery("select * from goodsinfo where code = '" + code + "'");
           if (!rs.next())
               throw new Exception("상품코드(" + code + ")에 해당하는 데이터가 없습니다.");
           String title = rs.getString("title");
           String writer = rs.getString("writer");
           int price = rs.getInt("price");
           request.setAttribute("CODE", code);
           request.setAttribute("TITLE", title);
           request.setAttribute("WRITER", writer);
           request.setAttribute("PRICE", new Integer(price));
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
        RequestDispatcher dsp = request.getRequestDispatcher("EditForm.jsp");
        dsp.forward(request, response);
        
   %>
</body>
</html>
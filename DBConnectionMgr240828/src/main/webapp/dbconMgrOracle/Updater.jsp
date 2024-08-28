<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="webdb.jdbcex.DBConnectionMgrOracle" %>
<%@ page  import="java.sql.*" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Updater.jsp 파일 -- 업데이트한 정보 입력</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		response.setContentType(
				"text/html; charset=UTF-8");
	    String code = request.getParameter("code");
	    String title = request.getParameter("title");
	    String writer = request.getParameter("writer");
	    String price = request.getParameter("price");
	    if (code == null || title == null || writer == null || price == null) 
	        throw new Exception("누락된 데이터가 있습니다.");
	    
	    DBConnectionMgrOracle  pool =
				DBConnectionMgrOracle.getInstance();
	    
	    Connection conn = null;
	    Statement stmt = null;
	    try {
	        //Class.forName("oracle.jdbc.driver.OracleDriver");
	        //conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
			//				"madang", "madang");
	        
	        conn = pool.getConnection();
	        
	        if (conn == null)
	            throw new Exception("데이터베이스에 연결할 수 없습니다.");
	        
	        stmt = conn.createStatement();
	        /*
	        String command = String.format("update goodsinfo set " +
	                              "title := '%s', writer := '%s', " +
	                              "price := %s where code = '%s';",
	                              title, writer, price, code);
	        */
	        String command = String.format("update goodsinfo set " +
                    "title = '%s', writer = '%s', " +
                    "price = '%s' where code = '%s'",
                    title, writer, price, code);
	        
	        
	        int rowNum = stmt.executeUpdate(command);
	        if (rowNum < 1)
	            throw new Exception("데이터를 DB에 입력할 수 없습니다.");
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
	    response.sendRedirect("UpdateResult.jsp?code=" + code);
%>
</body>
</html>
<%@ page import="java.sql.*"%> 
<%
	Connection conn = null;

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "madang";
	String password = "madang";

	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection(url, user, password);
%>